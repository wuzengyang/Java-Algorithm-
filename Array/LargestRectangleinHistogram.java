package array;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		int[] test = {5, 4, 1, 2};
		int result = largestRectangleArea(test);
		System.out.println(result);

	}

	public static int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}

		Deque<Element> stack = new LinkedList<>();
		int globalMax = Integer.MIN_VALUE;

		for (int i = 0; i < heights.length; i++) {

			while (!stack.isEmpty() && heights[i] < stack.peekLast().value) {
				Element temp = stack.pollLast();
                int next = stack.isEmpty()? -1 : stack.peekLast().index;
				globalMax = Math.max(globalMax, temp.value * (i - next - 1));
			}

			stack.offerLast(new Element(heights[i], i));
		}

		while (!stack.isEmpty()) {
				Element temp = stack.pollLast();
                int next = stack.isEmpty()? -1 : stack.peekLast().index;
				globalMax = Math.max(globalMax, temp.value * (heights.length - next - 1));
		}

		return globalMax;
	}

	public static class Element {
		int value;
		int index;

		public Element(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}
