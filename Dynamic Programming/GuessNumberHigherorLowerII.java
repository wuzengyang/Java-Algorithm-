package DP;

public class GuessNumberHigherorLowerII {
	
	public static void main(String[] args) {
		int test = 20;
		System.out.println(getMoneyAmount(test));
	}
	
    public static int getMoneyAmount(int n) {
        
        if (n <= 1) {
            return 0;
        }
        
        int[][] result = new int[n + 1][n + 1];
        // result[i][i] = 0
        for (int count = 1; count <= n; count++) {
            for (int i = 1; i + count <= n; i++) {
                int curMin = Integer.MAX_VALUE;
                for (int j = i; j < i + count; j++) {
                    curMin = Math.min(curMin, j + Math.max(result[i][j - 1], result[j + 1][i + count]));
                }
                result[i][i + count] = curMin;
            }
        }
        return result[1][n];
    }

}
