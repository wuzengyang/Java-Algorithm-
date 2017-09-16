package laiOfferTest;
import java.util.*;

public class AllAnagrams {
	
	public static void main(String[] args) {
		String s = "ab";
		String l = "accbabaccabbaccacabbab";
		System.out.println(allAnagrams(s, l));
	}
	
	  static List<Integer> allAnagrams(String s, String l) {
//		    // Write your solution here.
//		    // step 1, consider coner case\
//		    List<Integer> index = new ArrayList<>();
//		    if (l.length() == 0 || l.length() < s.length()) {
//		      return index;
//		    }
//		    
//		    //Step 2. creat a hashmap for s
//		    char[] shortString = s.toCharArray();
//		    char[] longString = l.toCharArray();
//		    Map<Character, Integer> map = new HashMap<>();
//		    for (char temp:shortString) {
//		      if (! map.containsKey(temp)) {
//		        map.put(temp, 1); 
//		      } else {
//		        map.put(temp, map.get(temp) + 1);
//		      }
//		    }
//		    int match = map.size();
//		    
//		    //traverse l with certain length sliding window 
//		    int slow = 0; 
//		    int fast = 0;
//		    for (; fast < shortString.length; fast++) { // creat a certain size window
//		    	if (map.containsKey(longString[fast])) {
//		        if (map.get(longString[fast]) == 0) {
//		          match = match + 1;
//		        }
//		        map.put(longString[fast], map.get(longString[fast]) - 1);
//		        if (map.get(longString[fast]) == 0) {
//		          match = match - 1;
//		        }
//
//		      }
//		    }
//		    
//		    if (match == 0) {
//		      index.add(slow);
//		    }
//		    
//		    // begin to traverse the left string
//		    while(fast < longString.length) {
//		      //poll out longString[slow] if it is contained in map
//		      if (map.containsKey(longString[slow])) {
//		        if (map.get(longString[slow]) == 0) {
//		          match += 1;
//		        }
//		        map.put(longString[slow], map.get(longString[slow]) +  1);
//		        
//		        if (map.get(longString[slow]) == 0) {
//		          match -= 1;
//		        }
//		      }
//		      slow++;
//		      
//		      //check if we need offer longString[fast]
//		      if (map.containsKey(longString[fast])) {
//		        if (map.get(longString[fast]) == 0) {
//		          match += 1;
//		        }
//		        
//		        map.put(longString[fast], map.get(longString[fast]) - 1);
//		        if (map.get(longString[fast]) == 0) {
//		          match = match -1;
//		        }
//
//		      }
//		      
//		      if (match == 0) {
//		          index.add(slow);
//		      }
//		      fast++;
//		    }
//		    
//		    return index;

		  // Laioffer's Method
		  List<Integer> result = new ArrayList<>();
		  if(l.length() == 0 || l.length() < s.length()) {
			  return result;
		  }
		  int match = 0;
		  Map<Character, Integer> map = getMap(s);
		  for (int i = 0; i < l.length(); i++) {
			  Integer count = map.get(l.charAt(i));
			  if (count != null) {
				  map.put(l.charAt(i), count - 1);
				  if (count == 1) {
					  match++;
				  }
			  }
			
			  
			  if (i >= s.length()) {
				  count = map.get(l.charAt(i - s.length()));
				  if (count != null) {
					  map.put(l.charAt(i - s.length()), count + 1);
					  if (count == 0) {
						  match--;
					  }  
				  }
			  }
			  
			  if(match == map.size()) {
				  result.add(i - s.length() + 1);
			  }
		  }
		  return result;
	  }
	  
	  public static Map<Character, Integer> getMap(String s) {
		  Map<Character, Integer> map = new HashMap<>();
		  for (int i = 0; i < s.length(); i++) {
			  Integer count = map.get(s.charAt(i));
			  if (count == null) {
				  map.put(s.charAt(i), 1);
			  } else {
				  map.put(s.charAt(i), count + 1);
			  }
		  }
		  return map;
	  }
}
