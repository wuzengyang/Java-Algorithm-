package laiOfferTest;

public class LongestValidParentheses {
	
	public static void main(String[] args) {
		String test = ")())(()()()(()";
		System.out.println(longestValidParentheses(test));
	}

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] input = s.toCharArray();
		for (int count = s.length() - 1; count >= 0; count--) {
			for (int i = 0; i + count < s.length(); i++) {
				if (validParentheses(input, i, i + count)) {
					System.out.println("valid fron index : " + i + " to " + (i + count));
					return count + 1;
				}
			}
		}
		return 0;
	}

	public static boolean validParentheses(char[] input, int left, int right) {

		int leftP = 0;
		int rightP = 0;
		while (left <= right) {
			if (input[left] == '(') {
				leftP += 1;
			} else {
				rightP += 1;
			}

			if (rightP > leftP) {
				return false;
			}

			left++;
		}

		return leftP == rightP ? true : false;
	}
}
