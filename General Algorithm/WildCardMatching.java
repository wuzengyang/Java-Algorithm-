package laiOfferTest;

public class WildCardMatching {
	
	public static void main(String[] args) {
		String input = "aaaaaaa";
		String pattern = "aaaaaaaaaa*";
		System.out.println(match(input, pattern));
	}
	
	

	public static boolean match(String input, String pattern) {
		    // Write your solution here.
		    // Assume both input and pattern are not null
		    // Assume there is at most one * in pattern
		    
		    if (input.length() == 0 && pattern.length() == 0) {
		      return true;
		    } else if (pattern.length() == 1 && pattern.charAt(0) == '*') {
		    	return true;
		    }
//		    
		     
		    return helper(input, pattern, 0, 0);
		  }
		  
		  public static boolean helper(String input, String pattern, int i, int j) {
		    // terminate condition
		    if (i == input.length() && j == pattern.length()) {
		      return true;
		    } else if (i == input.length() && j == pattern.length() - 1 && pattern.charAt(j) == '*') {
		      return true;
		    } else if (i >= input.length() || j >= pattern.length()) {
		    	return false;
		    }
		    
		    // actions in this layer
		    if (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
		      return helper(input, pattern, i + 1, j +1);
		    } else if (pattern.charAt(j) == '*') {
		    	if (j == pattern.length() - 1) {
		    		return true;
		    	}
		    	
		      for (int temp = 0; temp < input.length() - i; temp++) {
		        if (helper(input, pattern, i + temp, j + 1)) {
		          return true;
		        }
		      }
		    }
		    
		    return false;
		  }

}
