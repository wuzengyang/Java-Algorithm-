package laiOfferTest;

public class LargestSubMatrixSum {
	
	public static void main(String[] args) {
//		int[][] test = {{-4,  2,  -1,  0,  2},
//						{ 2,  3,   2,  1, -3},
//						{-3, -3,  -2,  2,  4},
//						{ 1,  1,   2, -2,  5},
//						{-4,  0,   1,  1, -4}};
		int[][] test = {{   1,    2, 3, 4,  5},
						{-100, -200, 100, 1, -8}};
		System.out.println(largest(test));
	}
	
	
	
	  public static int largest(int[][] matrix) {
		    // Write your solution here.
		    // Assume N >= 1 and M >= 1;
		    int N = matrix.length;
		    int M = matrix[0].length;
		    
		    // we need a prefix sum matrix for each col
		    int[][] prefixSum = new int[N][M];
		    for (int j = 0; j < M; j++) {
		      for (int i = 0; i < N; i++) {
		        if (i == 0) {
		          prefixSum[i][j] = matrix[i][j];
		        } else {
		          prefixSum[i][j] = matrix[i][j] + prefixSum[i - 1][j];
		        }
		        System.out.print(prefixSum[i][j] + " ");
		        
		      }
		      System.out.println(" ");
		    }
		    
		    // then check all possible rows combination: Cn2
		    // result is used to store curMax, row1, row2, col1, col2
		    int[] result;
		    int globalMax = Integer.MIN_VALUE;
		    int row1 = 0;
		    int row2 = 0;
		    int col1 = 0;
		    int col2 = 0;
		    for (int i = 0; i < N; i++) {
		      for (int j = i; j < N; j++) {
		        // two for loop traverses all two-ror combinations
		        // for each selected two-row combination, creat a new sum-array
		        int[] temp = new int[M];
		        for (int k = 0; k < M; k++) {
		          temp[k] = prefixSum[j][k] - prefixSum[i][k] + matrix[i][k];
		        }
		        result = helper(temp);
		        if (result[0] > globalMax) {
		          globalMax = result[0];
		          col1 = result[1];
		          col2 = result[2];
		          row1 = i;
		          row2 = j;
		        }
		      }
		    }
		    System.out.println("the matrix is:" + row1 + ", " + row2 + ", " + 
		    					col1 + ", " + col2);
		    return globalMax;
		  }
		  
		  public static int[] helper(int[] array) {
		    int[] result = new int[3];
		    int curMax = Integer.MIN_VALUE;
		    
		    //result[0] is globalmax; result[1] is col1; result[2] is col2
		    result[0] = Integer.MIN_VALUE; // globalMax
		    result[1] = 0; // start
		    result[2] = 0; // end
		    int start = 0;
		    for (int i = 0; i < array.length; i++) {
		      if (curMax <= 0) {
		        curMax = Math.max(curMax, array[i]);
		        start = i; // new start
		      } else {
		        curMax += array[i];
		      }
		      
		      if (curMax > result[0]) {
		        result[0] = curMax;
		        result[1] = start;
		        result[2] = i;
		      }
		    }
		    return result;
		  }

}
