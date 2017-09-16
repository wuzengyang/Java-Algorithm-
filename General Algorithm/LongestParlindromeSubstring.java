package laiOfferTest;

public class LongestParlindromeSubstring {
	public static void main(String[] args) {
		String test = "abbd";
		System.out.println(longestPalindrome(test));
	}

	public static String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		char[] string = s.toCharArray();
		for (int length = s.length() - 1; length >= 0; length--) {
			for (int i = 0; i + length < s.length(); i++) {
				if (checkPalindrome(string, i, i + length)) {
					return new String(string, i, length + 1);
				}
			}
		}
		return "";
	}

	public static boolean checkPalindrome(char[] string, int left, int right) {
		if (left > right) {
			return false;
		}

		while (left <= right) {
			if (string[left] == string[right]) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

}
