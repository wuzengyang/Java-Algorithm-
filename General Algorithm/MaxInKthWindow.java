package laiOfferTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxInKthWindow {
	public static void main(String[] args) {
	//	int[] test = {2,1,3,6,2,3,2,4,1,5,2,7,6,8,1,4};
		int[] test = {2, 1};
		System.out.print(maxWindows(test, 1));
	}

	public static List<Integer> maxWindows(int[] array, int k) {
		// Write your solution here.
		if (array.length == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> result = new ArrayList<>();

/*		// Method one, use a minHeap and lazy-deletion strategy
		PriorityQueue<Element> maxHeap = new PriorityQueue<>();
		for (int i = 0; i < array.length; i++) {
			maxHeap.offer(new Element(i, array[i]));
			if (i < k - 1) {
				continue;
			}
			while (!maxHeap.isEmpty()) {
				Element temp = maxHeap.peek();
				if (temp.index >= i - (k - 1)) {
					result.add(temp.value);
					break;
				} else {
					maxHeap.poll();
				}
			}
		}
		return result;*/
		
	    /**
	     * Method two: use a deque
	    */ 
	    Deque<Element> deque = new LinkedList<>();
	    deque.offerLast(new Element(0, array[0]));
	    for (int i = 0; i < array.length; i++) {
	      // check if we could add a element into the deque end
	      // step one: check if we have a head that is not within the window
	      if (!deque.isEmpty() && deque.peekFirst().index < i - k + 1) {
	        deque.pollFirst();
	      }
	      // step two: check if current element is larger than deque end
			while (true) {
				if (deque.isEmpty()) {
					deque.offerLast(new Element(i, array[i]));
					break;
				}
				if (array[i] >= deque.peekLast().value) {
					deque.pollLast();
				} else {
					deque.offerLast(new Element(i, array[i]));
					break;
				}
			}
	      //Step 3: add the largest value into the list
	      if (i >= k - 1) {
	        result.add(deque.peekFirst().value);
	      }
	    }
	    return result;
	}

	public static class Element implements Comparable<Element> {
		int index;
		int value;

		public Element(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Element another) {
			if (this.value == another.value) {
				return 0;
			}
			return this.value < another.value ? 1 : -1;
		}
	}

}
