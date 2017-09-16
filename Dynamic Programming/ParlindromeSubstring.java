package DP;

public class ParlindromeSubstring {
	
	public static void main(String[] args) {
		String test = "abcba";
		System.out.println(countSubstrings(test));
	}

	
    public static int countSubstrings(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] count = new int[1];
        for (int i = 0; i < s.length(); i++) {
            checkParlindrome(s, i, i, count); // check possible parlindrome substring centered by char i
            checkParlindrome(s, i, i + 1, count); // check possible parlindrome substring centered by char i and  i + 1;
        }
        return count[0];
    }
    
    public static void checkParlindrome(String s, int i, int j, int[] count) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count[0]++;
            i--;
            j++;
        }
        return;
    }
}
