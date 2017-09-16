package DP;

public class BombEnemy {
	
	public static void main(String[] args) {
		char[][] test = {
				{'0', 'E', '0', '0'},
				{'E', '0', 'W', 'E'},
				{'0', 'E', '0', '0'},
		};
		System.out.println(maxKilledEnemies(test));
	}
	
	
    public static int maxKilledEnemies(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int N = grid.length;
        int M = grid[0].length;
        int[][] result = new int[N][M];
        
        // step one: scan from left to right
        for (int i = 0; i < N; i++ ) {
            int enemyCnt = 0;
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '0') {
                    result[i][j] += enemyCnt; 
                } else if (grid[i][j] == 'E') {
                    enemyCnt++;
                } else {
                    enemyCnt = 0;
                }
            }
        }
        
        // step two: scan from right to left
        for (int i = 0; i < N; i++ ) {
            int enemyCnt = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (grid[i][j] == '0') {
                    result[i][j] += enemyCnt; 
                } else if (grid[i][j] == 'E') {
                    enemyCnt++;
                } else {
                    enemyCnt = 0;
                }
            }
        }
        
        // step three: scan from top to bottom
        for (int j = 0 ; j < M; j++ ) {
            int enemyCnt = 0;
            for (int i = 0; i < N; i++) {
                if (grid[i][j] == '0') {
                    result[i][j] += enemyCnt; 
                } else if (grid[i][j] == 'E') {
                    enemyCnt++;
                } else {
                    enemyCnt = 0;
                }
            }
        }
        
        // step four: scan from bottom to top
        int globalMax = Integer.MIN_VALUE;
        for (int j = 0 ; j < M; j++ ) {
            int enemyCnt = 0;
            for (int i = N - 1; i >=  0; i--) {
                if (grid[i][j] == '0') {
                    result[i][j] += enemyCnt; 
                    globalMax = Math.max(globalMax, result[i][j]);
                } else if (grid[i][j] == 'E') {
                    enemyCnt++;
                } else {
                    enemyCnt = 0;
                }
            }
        }
        
        return globalMax == Integer.MIN_VALUE? 0 : globalMax;
        
    }

}
