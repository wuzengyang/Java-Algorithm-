package laiOfferTest;
import java.util.*;

public class SmallestSubstringContainsAString {
	
		public static void main(String[] args) {
			String s1 = "abbbcdddddabceeeddaaadcac";
			String s2 = "aec";
			System.out.println(smallest(s1, s2));
		}

	
	  public static String smallest(String s1, String s2) {
		    // Write your solution here.
		    // two pointer, slow: always show the first matched char. 
		    // fast always show the last matched character
		    // Time O(n) space o (n)  HashMap
		    if (s1.length() < s2.length() || s1.length() == 0 || s2.length() == 0) {
		      return "";
		    }
		    
		    // creat a hashMap
		    Map<Character, Integer> map = new  HashMap<>();
		    for (int i = 0; i < s2.length(); i++) {
		      char temp = s2.charAt(i);
		      if (map.isEmpty() || !map.containsKey(temp) ) {
		        map.put(temp, 1);
		      } else {
		        map.put(temp, map.get(temp) + 1);
		      }
		    }
		    int match = map.size();
		    
		    // begin to traverse the string
		    int slow = 0, fast = 0;
		    int head = 0; 
		    int end = 0;
		    int globalMin = Integer.MAX_VALUE;
		    
		    while (fast < s1.length()) {
		      if ( map.containsKey(s1.charAt(fast))) {
		        int value = map.get(s1.charAt(fast));
		        if (value == 1 ) {
		          match -= 1;
		        } 
		        map.put(s1.charAt(fast), value - 1);

			   while (match == 0) {
			      // what if we can reduce the length from the head? 
			    		if (map.containsKey(s1.charAt(slow))) {
				            int value2 = map.get(s1.charAt(slow));
				            // case one, delete this item will not change match
				            if (value2 == 0) {
				              if (globalMin > fast - slow + 1) {
				                globalMin = fast - slow + 1;
				                head = slow;
				                end = fast;
				              }
				              // delate the item at slow 
				              map.put(s1.charAt(slow), value2 + 1);
				              match += 1;          
				           }
				           map.put(s1.charAt(slow), value2 + 1);	            
				       }
			    	   slow++;	
			     }
		      }
		       fast++;
		    }
		    if (globalMin != Integer.MAX_VALUE) {
		    	return s1.substring(head, end + 1);
		    } else {
		    	return "";
		    }
		    
		    
		  }
}
