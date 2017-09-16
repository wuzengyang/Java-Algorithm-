package DP;

public class MaximumProductSubarray {
	
	public static void main(String[] args) {
//		int[] test = {2,-5,-2,-4,3};
		int[] test = {1,-2, 9, 6};
		System.out.println(maxProduct(test));
	}

	public static int maxProduct(int[] A) {
	    if (A.length == 0) {
	        return 0;
	    }
	    
	    int maxherepre = A[0];
	    int minherepre = A[0];
	    int maxsofar = A[0];
	    int maxhere, minhere;
	    
	    for (int i = 1; i < A.length; i++) {
	        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
	        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
	        maxsofar = Math.max(maxhere, maxsofar);
	        maxherepre = maxhere;
	        minherepre = minhere;
	    }
	    return maxsofar;
	}

}
