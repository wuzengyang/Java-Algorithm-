package laiOfferTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args) {
		int[] test = {-1, 0, 0, 2, 3, 4, 5};
		allTriples(test, 4);
	}
	public static List<List<Integer>> allTriples(int[] array, int target) {
		// Write your solution here.
		if (array == null) {
			return null;
		}
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<>();
		int left = 0;
		while (left < array.length) {

			twoSum(array, array[left], left + 1, array.length - 1, target - array[left],
					result);
			while (left + 1 < array.length && array[left] == array[left + 1]) {
				left++;
			}
			left++;
		}
		return result;
	}

	public static void twoSum(int[] array, int check, int left, int right, int target,
			List<List<Integer>> result) {
		// Write your solution here.
		if (left >= right) {
			return;
		}

		while (left < right) {
			if (array[left] + array[right] == target) {
				result.add(Arrays.asList(check, array[left], array[right]));
//				System.out.println("["+ check + ", " + array[left] + ", " + array[right] + "]");
				while (left + 1 < right && array[left] == array[left + 1]) {
					left++;
				}
				left++;
			} else if (array[left] + array[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return;
	}
}
