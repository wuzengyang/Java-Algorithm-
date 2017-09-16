package DP;



public class UniqueSubstringsinWraparoundString {

	public static void main(String[] args) {
		String test = "abcdefghijklmnopqrstuvwxyzabcdefghijk"
				+ "lmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
				+ "abcdefghijklmnopqrstuvwxyzabcdefghijklmno"
				+ "pqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcde"
				+ "fghijklmnopqrstuvwxyzabcdefghijklmnopqrstu"
				+ "vwxyzabcdefghijklmnopqrstuvwxyzabcdefghijk"
				+ "lmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyza"
				+ "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopq"
				+ "rstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh"
				+ "ijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy"
				+ "zabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"
				+ "qrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"
				+ "hijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy"
				+ "zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqr"
				+ "stuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl"
				+ "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd"
				+ "efghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy"
				+ "zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrst"
				+ "uvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmno"
				+ "pqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijk"
				+ "lmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"
				+ "hijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"
				+ "hijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh"
				+ "ijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghi"
				+ "jklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghi"
				+ "jklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghi"
				+ "jklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghi"
				+ "jklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
//		String test = "cacacacabc";
		System.out.println(findSubstringInWraproundString(test));
	}

    public static int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0) {
			return 0;
		}

		if (p.length() == 1) {
			return 1;
		}
	    
        int[] count = new int[26];
        int cur = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && isValid(p.charAt(i - 1), p.charAt(i))) {
                cur++;
            } else {
                cur = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], cur);
            
        }

        int result = 0;
        for (int temp : count) {
            result += temp;
        }
	
        return result;
        
    }
    
    public static boolean isValid(char a, char b) {
        if (b - a == 1 || b - a == -25) {
            return true;
        }
        
        return false;
    } 

}
