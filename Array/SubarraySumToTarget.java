package array;

import java.util.HashSet;
import java.util.Set;

public class SubarraySumToTarget {
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3, 4};
		int t = 5;
		System.out.println(sumToTarget(test, t));
	}

	public static boolean sumToTarget(int[] array, int target) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return false;
		}

		Set<Integer> set = new HashSet<>();
		int curSum = 0;
		for (int i = 0; i < array.length; i++) {
			curSum += array[i];
			if (array[i] == target || curSum == target
					|| set.contains(curSum - target)) {
				return true;
			}

			set.add(curSum);
		}

		return false;
	}

}
