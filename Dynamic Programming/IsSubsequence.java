package DP;

public class IsSubsequence {
	
	public static void main(String[] args) {
		String s = "abc";
		String t = "asdadsdbfdfc";
		System.out.println(isSubsequence(t, s));
	}
	
    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == s.length() ? true : false;
        
    }

}
