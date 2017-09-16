package DP;

public class IntegerBreak {
	
	
	public static void main(String[] args) {
		int test = 500;
		System.out.println(integerBreak(test));
	}
	
	
    public static int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }
        
        if (n == 2) {
            return 1;
        }
        
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                result[i] = Math.max(result[i], Math.max(result[j], j) * Math.max(result[i - j], i - j));
            }
        }
        return result[n];
    }

}
