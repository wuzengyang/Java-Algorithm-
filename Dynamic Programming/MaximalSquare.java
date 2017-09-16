package DP;

import java.util.Arrays;

public class MaximalSquare {
	
	public static void main(String[] args) {
		String[][] test = new String[][] {{"10100"}, {"10111"},{"11111"},{"10010"}};
	}
	
	
	
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int N = matrix.length;
        int M = matrix[0].length;
        int[] result = new int[M];
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] preResult = Arrays.copyOf(result, M);
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0) {
                    result[j] = matrix[i][j] - '0';
                } else {
                    result[j] = matrix[i][j] == '0'? 0 : 1 + Math.min(result[j - 1], 
                                                Math.min(preResult[j - 1], preResult[j]));
                }
                globalMax = Math.max(globalMax, result[j]);
            }
        }
        return globalMax * globalMax;
        
    }

}
