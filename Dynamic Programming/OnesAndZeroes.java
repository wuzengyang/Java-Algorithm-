package DP;

import java.util.Arrays;

public class OnesAndZeroes {

	public static void main(String[] args) {
		String[] test = { "10", "0001", "111001", "1", "0" };
		// String[] test = { "0", "0", "1", "1" };
		// String[] test = { "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
		// "1", "0", "1", "0", "1", "0", "1", "0" };
		int m = 5;
		int n = 3;
		System.out.println(findMaxForm(test, m, n));
	}

	public static int findMaxForm(String[] strs, int m, int n) {
		if (strs == null || strs.length == 0) {
            return 0;
        } 
		
		int[][] result = new int[m + 1][n + 1];
		for (int i = 0; i < strs.length; i++) {
			int[] counts = onesAndZeros(strs[i]);
			for (int j = 0; j + counts[0] <= m; j++) {
				for (int k = 0; k + counts[1] <= n; k++) {
				
					result[j + counts[0]][k + counts[1]] = Math.max(result[j
							+ counts[0]][k + counts[1]], 1 + result[j][k]);
				

				}
			}
		}
		
/*		for (int i = 0; i < strs.length; i++) {
			int[] counts = onesAndZeros(strs[i]);
			for (int j = m; j - counts[0] >= 0; j--) {
				for (int k = n; k - counts[1] >= 0; k--) {

					result[j][k] = Math.max(result[j][k], 1 + result[j - counts[0]][k - counts[1]]);

				}
			}
		}*/

		return result[m][n];
		
	}
  
 


	public static int[] onesAndZeros(String input) {
		int[] result = new int[2];
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if (temp == '1') {
				result[1]++;
			} else {
				result[0]++;
			}
		}
		return result;
	}

}
