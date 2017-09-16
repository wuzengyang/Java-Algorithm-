package laiOfferTest;

public class ReplacementsOfAAndB {
	
	public static void main(String[] args) {
		String test = "aaaaaaaaaaaaaaababbbba";
		System.out.println(minReplacements(test));
	}
	
	
	  public static int minReplacements(String input) {
		    // Write your solution here.
		  	// set a pointer i, on the left of i include i are supposed all to be a (or replace b by a)
		    // on the right of i are supposed to be all b (replace a by b)
		    // count how many b at i left and how many a at i right, find out the min sum of these two numbers
		    
		    if (input.length() == 0) {
		      return 0;
		    }
		    
		    // Step one find out how many a and b this string
		    // Assume there are only a or b in input
		    int countA = 0;
		    int countB = 0;
		    for (int i = 0; i < input.length(); i++) {
		    	if (input.charAt(i) == 'a' ) {
		    		countA++;
		    	} else {
		    		countB++;
		    	}
		    }
		    
		    // then for each possible i, find action counts and findout the global min
		    
		    int left = 0;
		    int right = countA;
		    int globalMin = Math.min(countA, countB);
		    for (int i = 0; i < input.length(); i++) {
		    	if (input.charAt(i) == 'a') {
		    		// left keep the same, right reduce by 1
		    		right--;
		    	} else {
		    		left++;
		    	}
		    	globalMin = Math.min(globalMin, left + right);
		    }
		    
		    return globalMin;

		  }

}
