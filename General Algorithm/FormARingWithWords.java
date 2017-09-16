package laiOfferTest;
import java.util.*;

public class FormARingWithWords {
	
	public static void main(String[] args) {
		
		String[] test = {"aac", "bba", "ccd", "ddb"};
		System.out.println(formRing(test));
		
	}
	
		

	  public static boolean formRing(String[] input) {
		    // Write your solution here.
		    // a single string "aba" could also form a ring
		    
		    // need a hashSet
		    boolean[] check = new boolean[input.length];
		    List<String> result = new ArrayList<>();
		    List<List<String>> isRing = new ArrayList<>();
		    helper(input, check, isRing, result, 0);
		    return isRing.isEmpty() ? false : true;
		  }
		  
		  public static void helper(String[] input, boolean[] check, List<List<String>> isRing, List<String> result, int count) {
		    // terminate condition
		    if (count == input.length) {
		      String head = result.get(0);
		      String end = result.get(result.size() - 1);
		      if (head.charAt(0) == end.charAt(end.length() - 1)) {
		        isRing.add(new ArrayList<String>(result));
		        System.out.println(result);
		        return;
		      } 
		    }
		    
		    for (int i = 0; i < input.length; i++) {
		      // For the first string, add to the list
		      if (result.isEmpty()) {
		        result.add(input[i]);
		        check[i] = true;
		        helper(input, check, isRing, result, count + 1);
		        result.remove(input[i]);
		        check[i] = false;
		      } else {
		    	  // do recursion only this string is not used
		    	  if (! check[i]) {
		    		  String temp = result.get(result.size() - 1);
		    		  if (input[i].charAt(0) == temp.charAt(temp.length() - 1)) {
		    			  result.add(input[i]);
		    			  check[i] = true;
		    			  helper(input, check, isRing, result, count + 1);
		    			  result.remove(input[i]);
		    			  check[i] = false;
		    		  }
		    	  }
		      }
		    }
		    
		    return;
		}
}
