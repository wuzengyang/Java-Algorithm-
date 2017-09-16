package laiOfferTest;

public class OneEditDistance {
	
	public static void main(String[] args) {
		String s = "";
		String t = "x";
		System.out.println(oneEditDistance(s, t));
	}
	
	
	
	
	  public static boolean oneEditDistance(String s, String t) {
		    // Write your solution here.
		    // Use 2d DP
		  /*
		    if (s.length() == 0 && t.length() == 0) {
		      return false;
		    }
		    int sSize = s.length();
		    int tSize = t.length();
		    int[][]  result = new int[sSize + 1][tSize + 1];
		    for (int i = 0; i < sSize + 1; i++) {
		      for (int j = 0; j < tSize + 1; j++) {
		        if (i == 0) {
		          result[i][j] = j;
		        } else if (j == 0) {
		          result[i][j] = i;
		        } else {
		          if (s.charAt(i - 1) == t.charAt(j - 1) ) {
		            result[i][j] = result[i - 1][j - 1];
		          } else {
		            result[i][j] = 1 + Math.min(result[i - 1][j - 1], 
		                              Math.min(result[i - 1][j], result[i][j - 1]));
		          }
		        }
		      }
		    }
		    
		    return result[sSize][tSize] <= 1? true : false; */
		  
		    // Method2 : time O(n) space: O(1) but just for this case
		    if (Math.abs(s.length() - t.length()) > 1) {
		      return false; // two length cannot have length difference larger than 1
		    }

		    
		    int count = 0;
		    int i = 0; // index of s
		    int j = 0; // index of t
		    
		    while (i < s.length() && j < t.length()) {
		      if (s.charAt(i) == t.charAt(j)) {
		        i++;
		        j++;
		      } else {
		        if (s.length() > t.length()) {
		          i++;
		        } else if (s.length() < t.length()) {
		          j++;
		        } else {
		          i++;
		          j++;
		        }
		        count += 1;
		        if (count > 1) {
		          return false;
		        }
		      }
		    }
		    
		    if (i < s.length() || j < t.length()) {
		      count++;
		    }
		    
		    return count == 1? true : false;
		    
		  }

}
