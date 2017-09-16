package laiOfferTest;

import java.util.ArrayList;
import java.util.List;

public class MajorityNumberIII {
	public static void main(String[] args) {
		int[] test = {1, 3, 2, 5, 6, 7, 1, 3, 2, 3,1,9, 14, 15, 3, 1};
		System.out.println(majority(test, 5));
	}

	public static List<Integer> majority(int[] array, int k) {
		// write your solution here
		if (array == null || array.length == 0) {
			return new ArrayList<Integer>();
		}

		int[] num = new int[k - 1];
		int[] count = new int[k - 1];
		for (int i = 0; i < array.length; i++) {
			boolean check = false;
			// step one, check if we have same effective candidate in array
			for (int j = 0; j < k - 1; j++) {
				if (count[j] != 0 && array[i] == num[j]) {
					count[j]++;
					check = true;
					break;
				}
			}
			if (check) {
				continue; // we have finished all actions in this round
			}

			// now array[i]has not appeared yet
			for (int j = 0; j < k - 1; j++) {
				if (count[j] == 0) {
					num[j] = array[i];
					count[j]++;
					check = true;
					break;
				}
			}

			// now no space in num[] and array[i] is not any one of them
			if (!check) {
				for (int j = 0; j < k - 1; j++) {
					count[j]--;
				}
			}
		}

		// now we have k candidate and not duplicates
		for (int i = 0; i < k - 1; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < k - 1; j++) {
				if (array[i] == num[j]) {
					count[j]++;
					break;
				}
			}
		}

		// now find out the final results
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k - 1; i++) {
			if (count[i] > array.length / k) {
				result.add(num[i]);
			}
		}
		return result;
	}

}
