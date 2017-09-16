package laiOfferTest;

public class LongestCross1s {
	
	public static void main(String[] args) {
		int[][] test = {{0, 1, 1}, {1, 1, 1}, {1, 0, 0} };
		System.out.println(largest(test));
	}
	
	
	  public static int largest(int[][] matrix) {
		    // Write your solution here.
		    if (matrix.length == 0 || matrix[0].length == 0) {
		      return 0;
		    }
		    int N = matrix.length;
		    int M = matrix[0].length;
		    int[][] topBottom = new int[N][M];
		    int[][] bottomTop = new int[N][M];
		    int[][] leftRight = new int[N][M];
		    int[][] rightLeft = new int[N][M];
		    int[][] cross = new int[N][M];
		    
		    //Step one: traverse each col from top to bottom
		    for (int j = 0; j < M; j++) {
		      int curMax = 0;
		      for (int i = 0; i < N; i++ ) {
		        if (matrix[i][j] == 0) {
		          curMax = 0;
		        } else {
		          curMax += 1;
		        }
		        topBottom[i][j] = curMax;
		      }
		    }

		    //Step two: traverse each col from bottom to top
		    for (int j = 0; j < M; j++) {
		      int curMax = 0;
		      for (int i = N - 1; i >= 0; i-- ) {
		        if (matrix[i][j] == 0) {
		          curMax = 0;
		        } else {
		          curMax += 1;
		        }
		        bottomTop[i][j] = curMax;
		      }
		    }    
		    
		    //Step three: traverse each row from left to right
		    for (int i = 0; i < N; i++) {
		      int curMax = 0;
		      for (int j = 0; j < M; j++ ) {
		        if (matrix[i][j] == 0) {
		          curMax = 0;
		        } else {
		          curMax += 1;
		        }
		        leftRight[i][j] = curMax;
		      }
		    }    
		    
		    //Step four: traverse each row from right to left
		    for (int i = 0; i < N; i++) {
		      int curMax = 0;
		      for (int j = M - 1; j >= 0; j-- ) {
		        if (matrix[i][j] == 0) {
		          curMax = 0;
		        } else {
		          curMax += 1;
		        }
		        rightLeft[i][j] = curMax;
		      }
		    }     
		    
		    //Step five : combine four matrix and pick the smallest element 
		    int globalMax = 0;
		    int row = 0;
		    int col = 0;
		    for (int i = 0; i < N; i++) {
		      for (int j = 0; j < M; j++) {
		        cross[i][j] = Math.min(Math.min(topBottom[i][j], bottomTop[i][j]), 
		                               Math.min(leftRight[i][j], rightLeft[i][j]));
		        if (cross[i][j] > globalMax) {
		          globalMax = cross[i][j];
		          row = i;
		          col = j;
		        } 
		      }
		    }
		    
		    System.out.println("the row is: " + row);
		    System.out.println("the col is: " + col);
		    return globalMax;
		    
		    
		    
		  }

}
