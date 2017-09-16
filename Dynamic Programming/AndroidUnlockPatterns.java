package DP;

public class AndroidUnlockPatterns {
	
	
	public static void main(String[] args) {
		int m = 1;
		int n = 3;
		System.out.println(numberOfPatterns(m, n));
	}
	
    public static int numberOfPatterns(int m, int n) {
        
        if (n < m || n <= 0) {
        	return 0;
        }
        
        int[][] kpNext = new int[3][3];
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		kpNext[i][j] = 1;
        	}
        }
        
        int[] patterns = new int[n + 1];
        patterns[1] = 9;
        
        // initialize the matrix
        for (int count = 2; count <= n; count++) {
        	int[][] kpPre = new int[3][3];
        	for (int i = 0; i < 3; i++) {
            	for (int j = 0; j < 3; j++) {
            		kpPre[i][j] = kpNext[i][j];
            		kpNext[i][j] = 0;
            	}
            }
            
        	int cur = 0;
        	for (int i = 0; i < 3; i++) {
        		for (int j = 0; j < 3; j++) {
        			// check all eight directions
        			if (i - 1 >= 0 && j - 1 >= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i - 1][j - 1] + kpNext[i][j] :  kpPre[i - 1][j - 1] + kpNext[i][j] - 1;
        			}
        			if (i - 1 >= 0 && j>= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i - 1][j] + kpNext[i][j] :  kpPre[i - 1][j] + kpNext[i][j] - 1;
        			}
        			if (i - 1 >= 0 && j + 1 < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i - 1][j + 1] + kpNext[i][j] :  kpPre[i - 1][j + 1] + kpNext[i][j] - 1;
        			}
        			if (i >= 0 && j + 1 < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i][j + 1] + kpNext[i][j] :  kpPre[i][j + 1] + kpNext[i][j] - 1;
        			}
        			if (i + 1 < 3 && j + 1 < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i + 1][j + 1] + kpNext[i][j] :  kpPre[i + 1][j + 1] + kpNext[i][j] - 1;
        			}
        			if (i + 1 < 3 && j < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i + 1][j] + kpNext[i][j] :  kpPre[i + 1][j] + kpNext[i][j] - 1;
        			}
        			if (i + 1 < 3 && j - 1 >= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i + 1][j - 1] + kpNext[i][j] :  kpPre[i + 1][j - 1] + kpNext[i][j] - 1;
        			}
        			if (i < 3 && j - 1 >= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i][j - 1] + kpNext[i][j] :  kpPre[i][j - 1] + kpNext[i][j] - 1;
        			}
        			// And another eight 
        			if (i + 1 < 3 && j + 2 < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i + 1][j + 2] + kpNext[i][j] :  kpPre[i + 1][j + 2] + kpNext[i][j] - 1;
        			}
        			if (i - 1 >= 0 && j + 2 < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i - 1][j + 2] + kpNext[i][j] :  kpPre[i - 1][j + 2] + kpNext[i][j] - 1;
        			}
        			if (i + 1 < 3 && j - 2 >= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i + 1][j - 2] + kpNext[i][j] :  kpPre[i + 1][j - 2] + kpNext[i][j] - 1;
        			}
        			if (i - 1 >= 0 && j - 2 >= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i - 1][j - 2] + kpNext[i][j] :  kpPre[i - 1][j - 2] + kpNext[i][j] - 1;
        			}
        			
        			if (i + 2 < 3 && j + 1 < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i + 2][j + 1] + kpNext[i][j] :  kpPre[i + 2][j + 1] + kpNext[i][j] - 1;
        			}
        			if (i - 2 >= 0 && j + 1 < 3) {
        				kpNext[i][j] = count == 2 ? kpPre[i - 2][j + 1] + kpNext[i][j] :  kpPre[i - 2][j + 1] + kpNext[i][j] - 1;
        			}
        			if (i + 2 < 3 && j - 1 >= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i + 2][j - 1] + kpNext[i][j] :  kpPre[i + 2][j - 1] + kpNext[i][j] - 1;
        			}
        			if (i - 2 >= 0 && j - 1 >= 0) {
        				kpNext[i][j] = count == 2 ? kpPre[i - 2][j - 1] + kpNext[i][j] :  kpPre[i - 2][j - 1] + kpNext[i][j] - 1;
        			}
        			
        			cur += kpNext[i][j];
        		}
        	}
        	patterns[count] = cur;
        }
        
        int result = 0;
        for (int i = m; i <= n; i++) {
        	System.out.print(patterns[i] + ", ");
        	result += patterns[i];
        }
        return result;
    }

}
