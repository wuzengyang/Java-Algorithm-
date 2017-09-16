package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumClosest {
	
	public static void main(String[] args) {
		int[] test = {-1, 0, 1};
		int t = 0;
		System.out.println(closest(test, t));
	}
	
	
	  public static List<Integer> closest(int[] array, int target) {
		    // write your solution here
		    if (array == null || array.length <= 1) {
		      return new ArrayList<Integer>();
		    }
		    
		    int[] copy = Arrays.copyOf(array, array.length);
		    Arrays.sort(copy);
		    int left = 0; 
		    int right = copy.length - 1; 
		    int minDiff = Integer.MAX_VALUE;
		    int[] index = new int[2];
		    while (left < right) {
		      if (minDiff > Math.abs(target - copy[left] - copy[right])) {
		        minDiff = Math.abs(target - copy[left] - copy[right]);
		        index[0] = left;
		        index[1] = right;
		      }
		      if (copy[left] + copy[right] > target) {
		        right--;
		      } else {
		        left++;
		      }
		    }
		    
		    System.out.print(index[0] + ", " + index[1]);
		    return Arrays.asList(copy[index[0]], copy[index[1]]);
		  }

}
