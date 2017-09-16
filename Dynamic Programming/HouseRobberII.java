package DP;

public class HouseRobberII {
	
	public static void main(String[] args) {
		int[] test = {11, 3, 10, 1, 7, 9, 12};
		System.out.println(rob(test));
	}
	
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        // two different case
        // case one: If we rob the first house then the last will be safe
        int case1 = robHouses(nums, 0, nums.length - 2);
        // case two: if we did not rob the first house 
        int case2 = robHouses(nums, 1, nums.length - 1);
        return Math.max(case1, case2);
    }
    
    public static int robHouses(int[] nums, int left, int right) {
        int size = right - left + 1;
        if (size <= 0) {
            return 0;
        }
        if (size == 1) {
            return nums[left];
        }
        if (size == 2) {
            return Math.max(nums[left], nums[right]);
        }
        int pre1 = Math.max(nums[left], nums[left + 1]);
        int pre2 = nums[left];
        int result = 0;
        for (int i = 2; i < size; i++) {
            result = Math.max(nums[i + left] + pre2, pre1);
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
