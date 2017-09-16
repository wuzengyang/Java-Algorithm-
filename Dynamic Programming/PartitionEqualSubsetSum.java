package DP;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		int[] test = {1, 1};
		System.out.println(canPartition(test));
	}
	
	
	
    public static boolean canPartition(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        // calculate the sum of this array
        int sum = 0;
        for (int temp : nums) {
            sum += temp;
        }
        if (sum % 2 == 1) {  // sum must be even
            return false;
        }
        
        boolean[] result = new boolean[sum / 2 + 1];
        int w = sum / 2;
        result[0] = true;
        for (int i = 1; i <= nums.length - 1; i++) { // we cannot take the last nums into consideration 
            boolean[] preResult = Arrays.copyOf(result, result.length);
            for (int j = 0; j <= w; j++) {
                if (preResult[j] || (j - nums[i] >= 0 && preResult[j - nums[i]])) {
                    result[j] = true;
                }
            }
            if (result[w] == true) {
                return true;
            }
        }
        return false;
    }

}
