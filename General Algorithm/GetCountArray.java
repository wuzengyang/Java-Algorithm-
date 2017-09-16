package laiOfferTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GetCountArray {
	
	public static void main(String[] args) {
		int[] test = {4, 3 ,2 ,1 };
		int[] result = countArray(test);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}

	public static int[] countArray(int[] array) {
		// Write your solution here.
		if (array.length == 0) {
			return array;
		}
		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		int[] helper = new int[array.length];
		Map<Integer, Integer> map = new HashMap<>();
		findCount(copy, helper, 0, array.length - 1, map);

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				helper[i] = map.get(array[i]);
			} else {
				helper[i] = 0;
			}
		}
		return helper;
	}

	public static void findCount(int[] array, int[] helper, int left, int right,
			Map<Integer, Integer> map) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2;
		findCount(array, helper, left, mid, map);
		findCount(array, helper, mid + 1, right, map);
		merge(array, helper, left, mid, right, map);
	}

	public static void merge(int[] array, int[] helper, int left, int mid, int right,
			Map<Integer, Integer> map) {
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}

		int leftIndex = left;
		int rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] <= helper[rightIndex]) {
				array[left] = helper[leftIndex];
				Integer temp = map.get(helper[leftIndex]);
				temp = temp == null ? 0 : temp;
				map.put(helper[leftIndex], temp + rightIndex - mid - 1);
				leftIndex++;
				left++;
			} else {
				array[left++] = helper[rightIndex++];
			}
		}
		
		while (leftIndex <= mid) {
			array[left] = helper[leftIndex];
			Integer temp = map.get(helper[leftIndex]);
			temp = temp == null ? 0 : temp;
			map.put(helper[leftIndex], temp + rightIndex - mid - 1);
			leftIndex++;
			left++;
		}
	}

}
