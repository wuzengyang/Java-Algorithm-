package array;

public class NondecreasingArray {
	
	public static void main(String[] args) {
		int[] test = {3, 4, 2, 3};
		System.out.println(checkPossibility(test));
	}
	
    public static boolean checkPossibility(int[] nums) {
        
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        if (nums.length <= 2) {
            return true;
        }
        int count = 0;
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < curMax) {
            	count++;
            	if (i == 1) {
            		curMax = nums[i];
            	} else {
            		curMax = nums[i] > nums[i - 2] ? nums[i] : nums[i - 1];
            	}	
            } else {
            	curMax = nums[i];
            }
        }
        return count <= 1;
    }

}
