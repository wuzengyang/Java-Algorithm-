package DP;

public class FourKeysKeyboard {
	
	public static void main(String[] args) {
		int test = 9;
		System.out.println(maxA(test));
	}
	
	
    public static int maxA(int N) {
        
        
        if (N <= 0) {
            return 0;
        }
        
        int[] result = new int[N + 1];
        result[1] = 1;
        //result[2] = 1;
        for (int i = 2; i <= N; i++) {
            // case one: what if we just print one more A
            result[i] = result[i - 1] + 1;
            // case two" what if this is a copyed value
            for (int j = 1; j <= i - 3; j++) {
                result[i] = Math.max(result[j] * (i - 1 - j), result[i]);
            }
        }
        
        for (int i = 1; i <= N; i++ ) {
        	System.out.print(result[i] + ", ");
        }
        System.out.println();
        return result[N];
        
    }

}
