package DP;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySum {
	
	public static void main(String[] args) {
		int[] test = {23, 2, 4, 6, 7, 5, 3, 19, 2};
		int k = 0;
		System.out.println(checkSubarraySum(test, k));
	}
	
	
	
    public static boolean checkSubarraySum(int[] nums, int k) {
        
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i] % k;
            curSum = curSum % k;       
            if ( !set.isEmpty() && (set.contains(k - curSum) || set.contains(curSum))) {
                return true;
            }
            set.add(curSum);
        }
        return false;
        
    }

}
