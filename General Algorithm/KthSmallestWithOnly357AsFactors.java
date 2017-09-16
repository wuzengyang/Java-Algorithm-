package laiOfferTest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KthSmallestWithOnly357AsFactors {
	public static void main(String[] args) {
		int k = 3;
		System.out.println(kth(k));
	}

	public static long kth(int k) {
		// Write your solution here.
		if (k <= 0) {
			return 0;
		}
		
		PriorityQueue<Long[]> minHeap = new PriorityQueue<>(16, new Comparator<Long[]>(){
			@Override
			public int compare(Long[] a, Long[] b) {
				Long valueA = (long) (Math.pow( 3L, a[0]) * Math.pow(5L, a[1])
						* Math.pow(7L, a[2]));
				Long valueB = (long) (Math.pow( 3L, b[0]) * Math.pow(5L, b[1])
						* Math.pow(7L, b[2]));
				if (valueA.equals(valueB)) {
					return 0;
				} 
				return valueA < valueB? -1 : 1;
			}
		});
		
/*		PriorityQueue<Integer> minHeap = new PriorityQueue<>(16, new Comparator<Integer> () {
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		}
		);*/
		Set<Long> check = new HashSet<>();
		Queue<Long[]> queue = new LinkedList<>();
		queue.offer(new Long[] {1L, 1L, 1L});
		
		
	}
}
