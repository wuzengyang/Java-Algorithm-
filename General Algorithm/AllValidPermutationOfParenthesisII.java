package laiOfferTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllValidPermutationOfParenthesisII {
	public static void main(String[] args) {
		List<String> result = validParentheses(1, 1, 1);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.println();
		System.out.println("The size is: " + result.size());
	}

	public static List<String> validParentheses(int l, int m, int n) {
		// Write your solution here.
		if (l + m + n == 0) {
			return null;
		}
		List<String> result = new ArrayList<>();
		Deque<Character> stack = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		helper(0, 0, 0, 0, 0, 0, l, m, n, sb, stack, result);
		return result;
	}

	public static void helper(int lLeft, int lRight, int mLeft, int mRight, int nLeft,
			int nRight, int l, int m, int n, StringBuilder sb,
			Deque<Character> stack, List<String> result) {
		if (sb.length() == 2 * (l + m + n)) {
			result.add(sb.toString());
			return;
		}

		if (lLeft < l) {
			stack.offerFirst('(');
			sb.append('(');
			helper(lLeft + 1, lRight, mLeft, mRight, nLeft, nRight, l, m, n,
					sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.pollFirst();
		}
		
		if (lRight < lLeft) {
			if (!stack.isEmpty() && stack.peekFirst() == '(') {
				stack.pollFirst();
				sb.append(')');
				helper(lLeft, lRight + 1, mLeft, mRight, nLeft, nRight, l, m,
						n, sb, stack, result);
				sb.deleteCharAt(sb.length() - 1);
				stack.offerFirst('(');
			}
		}

		if (mLeft < m) {
			stack.offerFirst('[');
			sb.append('[');
			helper(lLeft, lRight, mLeft + 1, mRight, nLeft, nRight, l, m, n,
					sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.pollFirst();
		}
		

		
		if (mRight < mLeft) {
			if (!stack.isEmpty() && stack.peekFirst() == '[') {
				stack.pollFirst();
				sb.append(']');
				helper(lLeft, lRight, mLeft, mRight + 1, nLeft, nRight, l, m,
						n, sb, stack, result);
				sb.deleteCharAt(sb.length() - 1);
				stack.offerFirst('[');
			}
		}


		if (nLeft < n) {
			stack.offerFirst('{');
			sb.append('{');
			helper(lLeft, lRight, mLeft, mRight, nLeft + 1, nRight, l, m, n,
					sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.pollFirst();
		}


		if (nRight < nLeft) {
			if (!stack.isEmpty() && stack.peekFirst() == '{') {
				stack.pollFirst();
				sb.append('}');
				helper(lLeft, lRight, mLeft, mRight, nLeft, nRight + 1, l, m,
						n, sb, stack, result);
				sb.deleteCharAt(sb.length() - 1);
				stack.offerFirst('{');
			}
		}
	}

}
