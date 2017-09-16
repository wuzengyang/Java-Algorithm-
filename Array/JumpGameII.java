package array;

import java.util.Arrays;

public class JumpGameII {
	
	public static void main(String[] args) {
		int[] test = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3, 1, 3, 5, 2, 1, 3, 0, 2,7,0,9,6,9,6,1,7,9,0,1,2,9,0,3, 1, 3, 5, 2, 1, 3, 0, 2};
		System.out.println(jump(test));
		System.out.println(jump2(test));
	}

    public static int jump(int[] nums) {
        
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= nums.length - 1) {
                result[i] = 1;
                continue;
            }
            
            int curMin = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i]; j++) {
                if (result[i + j] >= 0)
                curMin = Math.min(curMin, result[i + j] + 1);
            }
            result[i] = curMin == Integer.MAX_VALUE? -1 : curMin;
        }
        return result[0];
    }
    
    public static int jump2(int[] nums) {
        
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int count = 0;
        int max = 0;
        int index = 0;
        while (max < nums.length - 1) {
        	int curMax = max;
        	while (index <= curMax) {
        		max = Math.max(max, nums[index] + index);
        		index++;
        	}
        	count++;
        }
        return count;
    }
}
