package laiOfferTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static void main(String[] args) {
		int[] test = {1,2,3,3,4 ,5,5,5,5,5,56,6,7};
		System.out.println(exist(test, 17));
	}

	public static List<List<Integer>> exist(int[] array, int target) {
		// Write your solution here.
		if (array == null || array.length < 4) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; i++) {
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < array.length - 2; j++) {
				if (j > i + 1 && array[j] == array[j - 1]) {
					continue;
				}
				// begin two sum
				int newTarget = target - array[i] - array[j];
				int left = j + 1;
				int right = array.length - 1;
				while (left < right) {
					if (array[left] + array[right] == newTarget) {
						result.add(Arrays.asList(array[i], array[j],array[left], array[right]));
						System.out.println(array[i] + ", "+array[j] +", "+ array[left] +", "+ array[right]);
						while(left + 1 < right && array[left + 1] == array[left]) {
							left++;
						}
						left++;
					} else if (array[left] + array[right] < newTarget) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return result;
	}
}
