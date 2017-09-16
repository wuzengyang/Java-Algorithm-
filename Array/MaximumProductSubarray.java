package array;

public class MaximumProductSubarray {
	
	public static void main(String[] args) {
		int[] test = {-2, 0, -1};
		System.out.println(maxProduct(test));
	}
	
	
	
	public static int maxProduct(int[] nums) {
		// The key point is to save any negtive results we got??
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int globalMax = nums[0];
	    int curMax = nums[0];
		int curMin = nums[0];
    
        for (int i = 1; i < nums.length; i++) {
            int preMax = curMax;
            int preMin = curMin;
            curMax = nums[i];
            curMin = nums[i];
            curMax = Math.max(curMax, Math.max(preMax * nums[i], preMin * nums[i]));
            curMin = Math.min(curMin, Math.min(preMax * nums[i], preMin * nums[i]));
            
            globalMax = Math.max(globalMax, curMax);
        }


		return globalMax;
	}

}
