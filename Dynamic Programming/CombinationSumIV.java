package DP;

public class CombinationSumIV {
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3};
		System.out.println(combinationSum4(test, 4));
	}
	
	
	
    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        
        int[] result = new int[target + 1];
        // initialize the array
        for(int temp : nums) {
            if (temp <= target) {
                result[temp] = 1;
            }
        }
        
        
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < nums.length; j++) {
                // find any possible combinations
                if (i + nums[j] <= target) {
                    result[i + nums[j]] += result[i];
                }
                
                
            }
        }
        return result[target];
        
    }

}
