package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		Interval a = new Interval(1, 3);
		Interval b = new Interval(8, 10);
		Interval c = new Interval(2, 6);
		Interval d = new Interval(15, 18);

		List<Interval> test = new ArrayList<>();
		test.add(a);
		test.add(b);
		test.add(c);
		test.add(d);
		
		List<Interval> result = merge(test);
		for (int i = 0; i < result.size(); i++) {
			System.out.print("<" + result.get(i).start + ", " + result.get(i).end + ">, ");
		}

	}

	public static List<Interval> merge(List<Interval> intervals) {

		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}

		Collections.sort(intervals, new MyComparator());
		List<Interval> result = new ArrayList<Interval>();

		result.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval temp = result.get(result.size() - 1);
			if (temp.end > intervals.get(i).start) {
				result.get(result.size() - 1).end = Math.max(temp.end,
						intervals.get(i).end);
			} else {
				result.add(new Interval(intervals.get(i).start, intervals
						.get(i).end));
			}
		}
		return result;
	}

	public static class MyComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval a, Interval b) {
			if (a.start == b.start) {
				return 0;
			}

			return a.start < b.start ? -1 : 1;
		}

	}

	public static class Interval {
		int start;
		int end;

		public Interval(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

}
