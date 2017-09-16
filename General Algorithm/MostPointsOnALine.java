package laiOfferTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostPointsOnALine {
	
	public static void main(String[] args) {
		Point[] points = new Point[2];
		points[0] = new Point(1, 2);
		points[1] = new Point(3, 6);
//		points[2] = new Point(2, 4);
//		points[3] = new Point(3, 6);
//		points[4] = new Point(2, 1);
		System.out.println(most(points));
	}

	public static int most(Point[] points) {
		// Write your solution here.
		// Method one: for for for loop, time O(n^2)

		// Method two: for for loop with a hashSet
		if (points == null || points.length <= 1) {
			return 0;
		}

		Map<List<Double>, Set<Point>> map = new HashMap<>();
		int globalMax = Integer.MIN_VALUE;

		for (int i = 0; i < points.length - 1; i++) {
			double k = 0;
			double b = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					k = Integer.MAX_VALUE;
					b = points[i].x;
				} else {
					k = ((double) (points[i].y - points[j].y))
							/ ((double) (points[i].x - points[j].x));
					b = ((double) (points[j].y * points[i].x - points[i].y
							* points[j].x))
							/ ((double) (points[i].x - points[j].x));
				}

				if (!map.containsKey(Arrays.asList(k, b))) {
					Set<Point> set = new HashSet<>();
					set.add(points[i]);
					set.add(points[j]);
					map.put(Arrays.asList(k, b), set);
				} else {
					Set<Point> set = map.get(Arrays.asList(k, b));
					set.add(points[i]);
					set.add(points[j]);
				}

				globalMax = Math.max(globalMax, map.get(Arrays.asList(k, b))
						.size());
			}
		}
		return globalMax;
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
