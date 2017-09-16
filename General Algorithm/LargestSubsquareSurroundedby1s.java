package laiOfferTest;

public class LargestSubsquareSurroundedby1s {
	
	public static void main(String[] args) {
		int[][] test = {
				{0, 1, 1, 1, 1},
				{1, 1, 0, 0, 1},
				{1, 1, 0, 0, 1},
				{0, 1, 1, 1, 1}
		};
		System.out.println(largestSubsquare(test));
	}
	
	public static int largestSubsquare(int[][] array) {
		if (array == null) {
			return 0;
		}
		
		if (array.length == 0 || array[0].length == 0) {
			return 0;
		}
		
		// again, we need four matrix
		int[][] topLeft;
		int[][] rightBottom;
		int[][] result; 
		
		topLeft = upLeft(array);
		rightBottom = rightBtm(array);
		result = merge(topLeft, rightBottom);
		return getMax(result);
 	}
	// get the top left matrix
	public static int[][] upLeft(int[][] array) {
		int N = array.length;
		int M = array[0].length;
		int[][] top = new int[N][M];
		int[][] left = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++){
				if (array[i][j] == 1) {
					if (i == 0 && j == 0) {
						top[i][j] = 1;
						left[i][j] = 1;
					} else if (i == 0) {
						top[i][j] = 1;
						left[i][j] = 1 + left[i][j - 1];
					} else if (j == 0) {
						top[i][j] = 1 + top[i - 1][j];
						left[i][j] = 1;
					} else {
						top[i][j] = 1 + top[i - 1][j];
						left[i][j] = 1 + left[i][j - 1];
					}
				}
			}
		}
		return merge(top, left);
	}
	// get the bottom right matrix
	public static int[][] rightBtm(int[][] array) {
		int N = array.length;
		int M = array[0].length;
		int[][] bottom = new int[N][M];
		int[][] right = new int[N][M];
		
		for(int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--){
				if (array[i][j] == 1) {
					if (i == N - 1 && j == M - 1) {
						bottom[i][j] = 1;
						right[i][j] = 1;
					} else if (i == N - 1) {
						bottom[i][j] = 1;
						right[i][j] = 1 + right[i][j + 1];
					} else if (j == M - 1) {
						bottom[i][j] = 1 + bottom[i + 1][j];
						right[i][j] = 1;
					} else {
						bottom[i][j] = 1 + bottom[i + 1][j];
						right[i][j] = 1 + right[i][j + 1];
					}
				}
			}
		}
		return merge(bottom, right);
	}
	
	public static int[][] merge(int[][] a, int[][] b) {
		int N = a.length;
		int M = a[0].length;
		int[][] result = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = Math.max(a[i][j], b[i][j]);
			}
		}
		return result;
	}
	
	public static int getMax(int[][] array) {
		int N = array.length;
		int M= array[0].length;
		int globalMax = 0;
		int row = 0;  // lefttop most point
		int col = 0;
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < M; j ++) {
				int curMax = 0;
				for (int k = 2; k < Math.min(N - i, M - j); k++) {
					curMax = Math.min(Math.min(array[i][j], array[i][j + k]), Math.min(array[i + k][j], array[i + k][j + k]));
					if (globalMax < curMax) {
						globalMax = curMax;
						row = i;
						col = j;
					}
				}
			}
		}
		
		System.out.println("The row is: " + row );
		System.out.println("The col is: " + col);
		return globalMax;
	}
	

}
