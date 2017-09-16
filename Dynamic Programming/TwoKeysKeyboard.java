package DP;

public class TwoKeysKeyboard {
	
	public static void main(String[] args) {
		int test = 9;
		System.out.println(minSteps(test));
	}
	
	
    public static int minSteps(int n) {
        if (n <= 1) {
            return 0;
        }    
        
        int[] result = new int[n + 1];
        result[1] = 0;
        
        for (int i = 2; i <= n; i ++) {
        	result[i] = i;
        	for (int j = 1; j < i / 2; j ++) {
        		if (i % j == 0) {
        			result[i] = Math.min(result[i], result[i / j] + j);
        		}
        	}
           
        }
        for (int i = 1; i <= n; i++) {
        	System.out.print(result[i] + ", ");
        }
        System.out.println();
        return result[n];
    }

}
