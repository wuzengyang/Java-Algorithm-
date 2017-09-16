package DP;

public class CountNumberswithUniqueDigits {
	
	public static void main(String[] args) {
		int test = 1;
		for (int i = 0; i <= 11; i++) {
			int result = countNumbersWithUniqueDigits(i);
			System.out.println("Result with n = " + i + " is: " + result);
		}
		
	}
	
    public static int countNumbersWithUniqueDigits(int n) {
    	if (n < 0) {
    		return 0; 
    	}
    	
    	if (n == 0) return 1;
    	if (n == 1) return 10;
/*    	int result[] = new int[n + 1];
    	result[0] = 1;
    	result[1] = 10;


    	for (int i = 2; i <= n; i++ ) {
    		if (i < 10) {
    			result[i] = (result[i - 1] - result[i - 2]) * (10 - i + 1) + result[i - 1];
    		} else {
    			result[i] = result[i - 1];
    		}
    	}
    	return result[n];*/
    	
    	int result = 0;
    	int pre1 = 10; 
    	int pre2 = 1;
    	
    	for (int i = 2; i <= n; i++ ) {
    		if (i < 10) {
    			result = (pre1 - pre2) * (10 - i + 1) + pre1;
    		    pre2 = pre1;
    		    pre1 = result;
    		} else {
    			break;
    		}
    	}
    	
    	return result;
    	
    }

}
