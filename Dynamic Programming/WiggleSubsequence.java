package DP;

public class WiggleSubsequence {
	
	public static void main(String[] args) {
		int[] test = {1,7,4,9,2,5};
		System.out.println(wiggleMaxLength(test));
	}
	
    public static int wiggleMaxLength(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 1;
        }
        
        int larger = 1;
        int smaller = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > nums[i - 1]) {
        		larger = smaller + 1;
        	} else {
        		smaller = larger + 1;;
        	}
        }
        return  Math.max(larger, smaller);
        
        
        
    }
}
