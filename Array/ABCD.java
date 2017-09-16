package array;

import java.util.HashSet;
import java.util.Set;

public class ABCD {
	public static void main(String[] args) {
		int[] test = {4,1,1,1,4,12,4};
		System.out.println(exist(test));
	}

	public static boolean exist(int[] array) {
		// Write your solution here.
		if (array == null || array.length < 4) {
			return false;
		}

		for (int i = 0; i < array.length; i++) {
			if (threeSum(array, array[i], i)) {
				return true;
			}
		}

		return false;
	}

	public static boolean threeSum(int[] array, int target, int index) {
		
		System.out.println("now check i = " + index);

		for (int i = 0; i < array.length - 2; i++) {
			if (i == index) {
				continue;
			}
			int newTarget = target - array[i];
			Set<Integer> set = new HashSet<>();
			for (int j = i + 1; j < array.length; j++) {			
				if (set.contains(newTarget - array[j])) {
					return true;
				} else {
					set.add(array[j]);
				}
			}
		}

		return false;
	}
}
