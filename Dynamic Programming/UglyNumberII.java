package DP;


public class UglyNumberII {
	
	public static void main(String[] args) {
		int test = 1600;
		System.out.println(nthUglyNumber(test));
	}

	
    public static int nthUglyNumber(int n) {
        
        if (n <= 0 || n > 1690) {
            return 0;
        }
        
        // treat it as a merge sort
        int[] result = new int [n];
        result[0] = 1;
        // we need three pointer
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            result[i] = min;
            if (min == factor2) {
                factor2 = result[++index2] * 2;
            }
            if (min == factor3) {
                factor3 = result[++index3] * 3;
            }
            if (min == factor5) {
                factor5 = result[++index5] * 5;
            }
        }
        return result[n - 1];
    }
}
