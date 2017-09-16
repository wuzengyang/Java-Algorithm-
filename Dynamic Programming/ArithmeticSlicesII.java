package DP;

public class ArithmeticSlicesII {
	
	public static void main(String[] args) {
		int[] test = {0,1,2,2,4, 2, 4};
		System.out.println(numberOfArithmeticSlices(test));
	}
	
	
    public static int numberOfArithmeticSlices(int[] A) {
        
        if (A == null || A.length <= 2) {
            return 0;
        }
        
        // three for loop, simulates when A[i] is head ...
        int count = 0;
        for (int i = 0; i < A.length - 2; i ++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                int step = A[j] - A[i];
                int pre = A[j];
                for (int k = j + 1; k < A.length; k++) {
                    if (A[k] - pre == step || A[k] - A[j] == step) {
                        count++;
                        pre = A[k];
                    }
                }
            }
        }
        return count;
    }

}
