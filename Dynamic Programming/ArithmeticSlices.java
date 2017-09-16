package DP;

public class ArithmeticSlices {
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3, 4, 5, 6};
		System.out.println(numberOfArithmeticSlices(test));
	}
	
	
    public static int numberOfArithmeticSlices(int[] A) {
        
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int count = 0;
        boolean[][] valid = new boolean[A.length][A.length];
        for (int len = 2; len < A.length; len++) {
            for (int i = 0; i + len < A.length; i++) {
                if (len == 2) {
                    valid[i][i + len] = 2 * A[i + 1] == A[i] + A[i + len]; 
                } else {
                    valid[i][i + len] = valid[i][i + len - 1] && valid[i + 1][i + len];
                }
                count = valid[i][i + len]? count + 1 : count;
                System.out.println("valid[" + i +"][" + (i + len) + "] is : " + valid[i][i + len]);
            }
        }
        return count;  
    }

}
