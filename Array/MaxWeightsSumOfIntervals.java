package array;

import java.util.Arrays;
import java.util.Comparator;

public class MaxWeightsSumOfIntervals {

	public int maxWeightSum(IntervalW[] intervals) {
		// Write your solution here.
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		IntervalW[] copy = Arrays.copyOf(intervals, intervals.length);
		Arrays.sort(copy, new myComparator());
		int[] result = new int[copy.length + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= copy.length; i++) {
			int curMax = copy[i].weight;
			for (int j = 1; j < i; j++) {
				if (copy[i].start > copy[j].end) {
					curMax = Math.max(max, result[j] + copy[i].weight);
				}
			}
			result[i] = curMax;
			max = Math.max(max, result[i]);
		}

		return max;
	}

	public class myComparator implements Comparator<IntervalW> {
		@Override
		public int compare(IntervalW a, IntervalW b) {
			if (a.start == b.start) {
				return 0;
			}

			return a.start < b.start ? -1 : 1;
		}
	}

	class IntervalW {
		public int start;
		public int end;
		public int weight;

		public IntervalW(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

}
