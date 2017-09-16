package array;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public static void main(String[] args) {
		int[] test = {1,2,4,8,16,32,64,128};
		int t = 82;
		System.out.println(threeSumClosest(test, t));
	}
	
	
    public static int threeSumClosest(int[] nums, int target) {
        
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int curSum = copy[0] + copy[1] + copy[2];
        
        if (curSum > target) {
            return curSum;
        }
        
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
         for (int i = 0; i < copy.length - 2; i++) {
        	int k = copy.length - 1;
        	int j = i + 1;
            while (j < k) {
                curSum = copy[i] + copy[j] + copy[k];
                if (minDiff > Math.abs(curSum - target)) {
                	minDiff = Math.abs(curSum - target);
                	result = curSum;
                }
                minDiff = Math.min(minDiff, Math.abs(curSum - target));
                
                if (curSum == target) {
                    return target;
                }
                
                if (curSum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return result;
        
    }

}
