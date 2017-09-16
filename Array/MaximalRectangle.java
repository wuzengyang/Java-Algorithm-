package array;

public class MaximalRectangle {
	
	
	public static void main(String[] args) {
		int[][] test = {{0, 1, 1, 0, 1},
						{1, 1 ,0 ,1 ,0},
						{0, 1, 1, 1, 0},
						{1, 1, 1 ,1, 0},
						{1, 1, 1 ,1, 1},
						{0, 0, 0 ,0, 0}};
		System.out.println(maximalRectangle(test));
	}
	
	
    public static int maximalRectangle(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] left = new int[N + 1][M + 1];
        int[][] top = new int[N + 1][M + 1];
        
        int globalMax = Integer.MIN_VALUE;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(matrix[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    top[i][j] = top[i - 1][j] + 1;
                }
                
                // calculation
                int curMin = Integer.MAX_VALUE;
                for (int k = 0; k < top[i][j]; k++) {
                    curMin = Math.min(left[i - k][j], curMin);
                    globalMax = Math.max(globalMax, (k + 1) * curMin);
                }
                
            }
        }
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		System.out.print(left[i][j] + ", ");
        	}
        	System.out.println();
        }
        System.out.println();
        
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= M; j++) {
        		System.out.print(top[i][j] + ", ");
        	}
        	System.out.println();
        }
        System.out.println();
        
        
        return globalMax == Integer.MIN_VALUE? 0 : globalMax;
        
    }

}
