package laiOfferTest;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecLargest {
	
	public static void main(String[] args) {
		int[] test = {2, 1, 5, 4, 3, 6, 9, 14, -1};
		System.out.println(largestAndSecond(test)[0]);
		System.out.println(largestAndSecond(test)[1]);
	}

	public static int[] largestAndSecond(int[] array) {
		// Write your solution here.
		// The first element is the largest number,
		// the second element is the second largest number.

		// first add all nodes into the list
		int index = 0;
		List<Node> result = new ArrayList<>();
		while (index < array.length) {
			Node temp = new Node(array[index++]);
			result.add(temp);
		}

		while (result.size() > 1) {
			// compare all two-node pairs
			index = 0;
			while (index + 1 < result.size()) {
				if (result.get(index).key > result.get(index + 1).key) {
					result.get(index).smaller.add(new Node(result
							.get(index + 1).key));
					result.remove(index + 1);
				} else {
					result.get(index + 1).smaller.add(new Node(result
							.get(index).key));
					result.remove(index);
				}
				index++;
			}
		}

		int max = result.get(0).key;
		int secMax = Integer.MIN_VALUE;
		for (int i = 0; i < result.get(0).smaller.size(); i++) {
			secMax = Math.max(secMax, result.get(0).smaller.get(i).key);
		}

		return new int[] { max, secMax };
	}

	// a helper structure Node
	public static class Node {
		int key;
		List<Node> smaller = new ArrayList<>();

		public Node(int key) {
			this.key = key;
		}
	}

}
