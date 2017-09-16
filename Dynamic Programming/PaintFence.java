package DP;

public class PaintFence {
	
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(numWays(n, k));
	}
	
    public static int numWays(int n, int k) {
        // n nad k are only non-negative
        // not guranteed t0 be positive
        
    	//Three base cases
        if (n <= 0 || k <= 0) {
            return 0;
        }
        if (n == 1) {
        	return k;
        }
        if (n == 2) {
        	return k*k;
        }
        
        // induction rule: 
        // case one: element i - 1 has the same color as element i - 2 , then p1 = r[i - 2] * (k - 1)
        // case two: element i - 1 has different color as element i - 2, then p2 = r[i - 1] *(k - 1)
        // in total : r[i] = r[i - 2] * (k^2 - 1)
        int pre2 = k;
        int pre1 = k*k;
        int result = 0;
        for (int i = 3; i <= n; i++) {
        	result = (pre1 + pre2) * (k - 1);
        	pre2 = pre1;
        	pre1 = result;
        }
        return result;
    }

}








