package laiOfferTest;

import java.util.Arrays;
import java.util.Comparator;


public class LargestPointsWithPositiveSlope {

	public static void main(String[] args) {
		Point[] points = new Point[9];
		points[0] = new Point(0, 1);
		points[1] = new Point(2, 2);
		points[2] = new Point(2, 3);
		points[3] = new Point(3, 3);
		points[4] = new Point(3, 3);
		points[5] = new Point(3, 2);
		points[6] = new Point(4, 2);
		points[7] = new Point(5, 5);
		points[8] = new Point(6, 9);

		System.out.println(largest(points));
	}

	public static int largest(Point[] points) {
		// Write your solution here.
		if (points == null || points.length <= 1) {
			return 0;
		}
		Arrays.sort(points, new MyComparator());
		return longest(points);
	}

	public static int longest(Point[] array) {
		// Write your solution here.
		// Time O(n^2)
		if (array == null || array.length <= 1) {
			return 0;
		}
		// we need two array to store past results
		int[] result = new int[array.length];
		int globalMax = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int curMax = 0;
			for (int j = 0; j < i; j++) {
				if (array[i].y > array[j].y) {
					curMax = Math.max(curMax, result[j] + 1);
				}
			}
			result[i] = curMax;
			globalMax = Math.max(curMax, globalMax);
		}
		// since we start from 0
		return globalMax == 0? 0 : globalMax + 1;
	}

	public static class MyComparator implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			if (a.x == b.x) {
				return 0;
			}
			return a.x < b.x ? -1 : 1;
		}
	}

	public static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
