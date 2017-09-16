package laiOfferTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortInSpecifiedOrder {

	public int[] sortSpecial(int[] A1, int[] A2) {
		// Write your solution here.
		Integer[] temp = new Integer[A1.length];
		for (int i = 0; i < A1.length; i++) {
			temp[i] = A1[i];
		}
		Arrays.sort(temp, new MyComparator(A2));

		int[] sorted = new int[A1.length];
		for (int i = 0; i < A1.length; i++) {
			sorted[i] = temp[i];
		}
		return sorted;
	}

	public class MyComparator implements Comparator<Integer> {
		private Map<Integer, Integer> map = new HashMap<>();

		public MyComparator(int[] array) {
			for (int i = 0; i < array.length; i++) {
				map.put(array[i], i);
			}
		}

		@Override
		public int compare(Integer a, Integer b) {
			Integer i1 = map.get(a);
			Integer i2 = map.get(b);
			// case1: both i1 and it are not null
			if (i1 != null && i2 != null) {
				return i1.compareTo(i2);
			}
			// case2: both i1 and i2 are null
			if (i1 == null && i2 == null) {
				return a.compareTo(b);
			}
			return i1 == null ? 1 : -1;
		}
	}

}
