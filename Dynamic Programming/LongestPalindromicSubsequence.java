package DP;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		String test = "bbbab";
		System.out.println(longestPalindromeSubseq(test));
	}
	
	
	
    public static int longestPalindromeSubseq(String s) {
        
        // reverse the string to a new string, and find common subssequence of these two string
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] input = s.toCharArray();
        char[] reverse = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            reverse[i] = input[input.length - 1 - i];
        }
        
        int[] result = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            int[] pre = Arrays.copyOf(result, result.length);
            for (int j = 1; j <= input.length; j++) {
                result[j] = input[i - 1] == reverse[j - 1] ? pre[j - 1] + 1 : Math.max(result[j - 1], pre[j]);
            }
        }
        return result[input.length];
    }

}
