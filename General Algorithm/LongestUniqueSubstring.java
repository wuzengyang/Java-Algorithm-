package laiOfferTest;
import java.util.*;

public class LongestUniqueSubstring {
	
	public static void main(String[] args) {
		String test = "abcaaqwertyu";
		System.out.println(longest(test));
	}
	
	  public static int longest(String input) {
		    // Write your solution here.
		    if (input.length() == 0) {
		      return 0;
		    }
		    
		    char[] inputString = input.toCharArray();
		    int slow = 0;
		    int fast = 0;
		    int maxLength = 0;
		  
		    Map<Character, Integer> map = new HashMap<Character, Integer>();

		    while (fast < inputString.length) {
		      if (! map.containsKey(inputString[fast])) {
		        map.put(inputString[fast++], 1);
		      } else {
		         map.put(inputString[fast], map.get(inputString[fast]) + 1);
		        if (fast - slow > maxLength) {
		          maxLength = fast - slow;
		        }
		        while (checkContains(map)) {
		          map.remove(inputString[slow++]);
		        }
		      }
		    }
		    if (fast - slow > maxLength) {
		    	return fast - slow;
		    } else {
		    	return maxLength;
		    }
		    //return maxLength;
		  }
		  
		  public static boolean checkContains(Map<Character, Integer> map) {
		    
		    for (Map.Entry<Character, Integer> temp : map.entrySet()) {
		      if (temp.getValue() > 1) {
		        return true;
		      }
		    }
		    return false;
		  }
}
