package laiOfferTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KthCloestPoint {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int[] c = {7, 8, 9};
		List<Integer> result = closest(a, b, c, 6);
		System.out.println(result);
	}

	public static List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		    // Write your solution here.
		    if (k > a.length * b.length * c.length) {
		      return Arrays.asList(0, 0, 0);
		    }
		    int i = 0; 
		    int j = 0;
		    int m = 0;
		    Set<List<Integer>> set = new HashSet<>();
		    PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(k, new Comparator<Integer[]>() {
		    	@Override
		    	public int compare(Integer[] a, Integer[] b) {
		    		Integer valueA = a[0]*a[0] + a[1]*a[1] + a[2]*a[2];
		    		Integer valueB = b[0]*b[0] + b[1]*b[1] + b[2]*b[2];
		    		return valueA.compareTo(valueB);
		    	}
		    	
		    });
		    set.add(Arrays.asList(i, j, m));
		    minHeap.offer(new Integer[] {a[0], b[0], c[0], 0, 0, 0});
		    while(k > 1) {
		    	Integer[] temp = minHeap.poll();
//		    	System.out.print(temp[0] + "; " + temp[1] + ", " + temp[2]);
//		    	System.out.println();
		    	if (temp[3] + 1 < a.length && set.add(Arrays.asList(temp[3] + 1, temp[4], temp[5]))) {
		    		minHeap.offer(new Integer[] {a[temp[3] + 1], b[temp[4]], c[temp[5]], temp[3] + 1, temp[4], temp[5]});
		    	}
		    	if (temp[4] + 1 < b.length && set.add(Arrays.asList(temp[3], temp[4] + 1, temp[5]))) {
		    		minHeap.offer(new Integer[] {a[temp[3]], b[temp[4] + 1], c[temp[5]], temp[3], temp[4] + 1, temp[5]});
		    	}
		    	if (temp[5] + 1 < c.length && set.add(Arrays.asList(temp[3], temp[4], temp[5] + 1))) {
		    		minHeap.offer(new Integer[] {a[temp[3]], b[temp[4]], c[temp[5] + 1], temp[3], temp[4], temp[5] + 1});
		    	}
		    	k--;
		    }
		    Integer[] result = minHeap.poll();
		    return Arrays.asList(result[0], result[1], result[2]);
		  }
}
