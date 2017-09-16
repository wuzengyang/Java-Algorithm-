package array;

import java.util.Arrays;

public class LongestBitonicSequence {
	
	public static void main(String[] args) {
		int[] test = {1, 3, 2, 1, 4, 6, 1};
		System.out.println(longestBitonic(test));
	}
	
	  public static int longestBitonic(int[] array) {
		    // Write your solution here.
		    if (array == null || array.length == 0) {
		      return 0;
		    }
		    if (array.length == 1) {
		      return 1;
		    }
		    //lets try binary search method
		    // first find ascending order subsequence
		    int[] ascending = new int[array.length + 1];
		    int[] descending = new int[array.length + 1];
		    int[] checkA = new int[array.length];
		    int[] checkD = new int[array.length];
		    int lenA = 0;
		    int lenD = 0;
		    for (int i = 1; i <= array.length; i++) {
		      int indexA = Arrays.binarySearch(checkA, 0, lenA, array[i -1]);
		      indexA = indexA < 0? - (indexA + 1) : indexA;
		      checkA[indexA] = array[i - 1];
		      ascending[i] = indexA;
		      lenA = indexA == lenA? lenA + 1 : lenA;
		      
		      int indexD = Arrays.binarySearch(checkD, 0, lenD, array[array.length - i]);
		      indexD = indexD < 0? - (indexD + 1) : indexD;
		      checkD[indexD] = array[array.length - i];
		      descending[array.length - i + 1] = indexD;
		      lenD = indexD == lenD? lenD + 1 : lenD;
		    }
		    
		    int max = Integer.MIN_VALUE;
		    for (int i = 1; i <= array.length; i++) {
		      max = Math.max(ascending[i] + descending[i] + 1, max);
		    }
		    return max;
		  }

}
