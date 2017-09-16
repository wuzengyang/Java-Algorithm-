package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		int[] test = {1, 0, -1, 0, -2, 2};
		int t = 0;
		System.out.println(fourSum(test, t));
	}
	
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        Arrays.sort(nums);
        if (4 * nums[0] > target || 4 * nums[nums.length - 1] < target) {
            return result;
        }
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (4 * nums[i] > target) {
            	System.out.println("break at i = " + i);
                break;
            }
            
            if (i > 0 && nums[i] == nums[i - 1]) {
            	continue;
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {
         	
                if (3 * nums[j] + nums[i] > target) {
                	System.out.println("break at i = " + i + " and j = " + j);
                    break;
                }
                
                if (j > j + 1 && nums[j] == nums[j - 1]) {
                	continue;
                }
                
                twoSum(nums, i, j, j + 1, nums.length - 1, target - nums[i] - nums[j], result);
            }
        }
        return result;
    }
    
    public static void twoSum(int[] nums, int a, int b, int left, int right, int target, List<List<Integer>> result) {
        
        while (left < right) {
 	
			if (nums[left] + nums[right] == target) {
				result.add(Arrays.asList(nums[a], nums[b], nums[left],
						nums[right]));
				while (right > left && nums[right] == nums[right - 1]) {
					right--;
				}
				right--;
				while (right > left && nums[left] == nums[left + 1]) {
					left++;
				}  
				left++;
            } else if (nums[left] + nums[right] > target) {
            	right--;
            } else {
            	left++;
            }
              	

        }
        return;
        
    }
}
