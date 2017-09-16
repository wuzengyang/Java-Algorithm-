package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		int[] test = {95, 5, 3, 93, 2, 91, 92, 4};
		System.out.println(longestConsecutive(test));
	}

	public static int longestConsecutive(int[] array) {
		// Write your solution here.

		if (array == null || array.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		for (int temp : array) {
			set.add(temp);
		}

		int max = 1;

		for (int i = 0; i < array.length; i++) {
			int curMax = 0;
			int cur = array[i];
			while (set.remove(cur--)) {
				curMax++;
			}

			cur = array[i] + 1;
			while (set.remove(cur++)) {
				curMax++;
			}

			max = Math.max(curMax, max);
		}

		return max;
	}

}
