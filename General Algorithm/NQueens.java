package laiOfferTest;
import java.util.*;

public class NQueens {
	
	public static void main(String[] args) {
		int n = 1;
		List<List<Integer>> test = nqueens(n);
		System.out.println(test);
		
	}
	
	
	
	
	  public static List<List<Integer>> nqueens(int n) {
		    // Write your solution here.
		    if (n == 0) {
		      return null;
		    }
		    List<List<Integer>> result = new ArrayList<>();
		    List<Integer> oneWay = new ArrayList<>();
		    helper(result, oneWay, n, 0);
		    return result;
		  }
		  
		  public static void helper(List<List<Integer>> result, List<Integer> list, int n, int row) {
		    if (row == n) {
		      result.add(new ArrayList<Integer>(list));
		      //System.out.println(list);
		    }
		    
		    for (int i = 0; i < n; i++) {
		      list.add(i);
		      if(passCheck(list)) {
		        helper(result, list, n, row + 1);
		      }
		      list.remove(row);
		    }
		  }
		  
		  public static boolean passCheck(List<Integer> list) {
		    for (int i = 0; i < list.size() - 1; i++) {
		      // case one, item at the same col with any previous elements
		      if (list.get(list.size() - 1) == list.get(i)) {
		        return false;
		      } else if (list.size() - 1 - i == Math.abs(list.get(list.size() - 1) - list.get(i))) {
		        return false; 
		      }
		      
		    }
		    return true;
		  }

}
