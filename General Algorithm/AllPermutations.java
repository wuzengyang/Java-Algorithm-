package laiOfferTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllPermutations {
		public static void main(String[] args) {
			String name = "abbbbb";
			List<String> result = permutations(name);
			for (String temp : result) {
				System.out.println(temp);
			}
		}
	
	  public static List<String> permutations(String set) {
		    // Write your solution here.
		    // time (n!) O(n!) = n*  n-1 * n-2 * ... *n
		    List<String> result = new ArrayList<String>();
		    
		    if (set == null) {
		      return result;
		    }
		    
		    if (set.length() == 0) {
		      result.add(set);
		      return result;
		    }
		    char[] input = set.toCharArray();
		    helper(input, 0, result);
		    return result;
		  }
		  
		  public static void helper(char[] input, int index, List<String> result) {
		    if (index == input.length) {
		      result.add(new String(input));
		      return;
		    }
		    HashSet<Character> checkContain = new HashSet<Character>();
		    for (int i = index; i < input.length; i++) {
		      if (! checkContain.contains(input[i])) {
		        checkContain.add(input[i]);
		        
		        swap(input, index, i);
		        helper(input, index + 1, result);
		        swap(input, index, i);
		      }
		    }
		  }
		  
		  public static void swap (char[] input, int a, int b) {
		    char temp;
		    temp = input[a];
		    input[a] = input[b];
		    input[b] = temp;
		  }

}
