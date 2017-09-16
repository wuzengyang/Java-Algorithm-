package laiOfferTest;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		//int[] test = { 1, 5, 6, 6, 2, 3, 5, 6, 3, 4, 4, 2 };
		// int[] test = { 2, 1, 3, 3, 4 };
		 int[] test = {5,4,3,2,1};
		System.out.print(largest(test));
	}

	public static int largest(int[] array) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return 0;
		}

		// Use a stack to record all ascending elements' indices
		Deque<Integer> check = new LinkedList<>();
		int globalMax = Integer.MIN_VALUE;
		int i = 0;

		while (i < array.length) {
			if (check.isEmpty() || array[i] >= array[check.peekFirst()]) {
				check.offerFirst(i);
				i++; // now we move to the next array element
			} else {
				Integer temp = check.pollFirst(); 
				// now we find the left edge for all elements in stack
				Integer next = check.peekFirst();
				next = next == null ? -1 : next;
				globalMax =	Math.max(globalMax, array[temp] * (i - 1 - next));
			}
		}

		if (!check.isEmpty()) {
			// now temp2 is the right edge and is the largest
			// this part is very tricky, we have to ensure where is the left
			// edge for each element in stack
			Integer temp2 = check.pollFirst();
			globalMax = Math.max(globalMax, array[temp2]);
			while (!check.isEmpty()) {
				Integer temp3 = check.pollFirst();
				Integer next = check.peekFirst();
				next = next == null ? -1 : next;
				globalMax =Math.max(globalMax, array[temp3] * (temp2 - next));
			}
		}
		return globalMax;
	}

}
