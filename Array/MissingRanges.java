package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static void main(String[] args) {
		int[] test = {-2147483648,-2147483648,0,2147483647,2147483647};
		int l = -2147483648;
		int u = 2147483647;
		
		System.out.println(findMissingRanges(test, l, u));
	}
	
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                list.add(String.valueOf(lower));
            } else {
                list.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return list;
        }
        
        
        if (nums[0] > lower) {
            int temp = lower + 1;
            if (temp == nums[0]) {
                list.add(String.valueOf(lower));
            } else {
                list.add(String.valueOf(lower) + "->" + String.valueOf(nums[0] - 1));
            }
        }
        
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] == nums[i - 1]) {
        		continue;
        	}
        	
            if (nums[i - 1] + 2 < nums[i]) {
                list.add(String.valueOf(nums[i - 1] + 1) + "->" + String.valueOf(nums[i] - 1));
            } else if (nums[i - 1] + 2 == nums[i]) {
                list.add(String.valueOf(nums[i] - 1));
            }
        }
        
        if (nums[nums.length - 1] < upper) {
            int temp = nums[nums.length - 1] + 1;
            if (temp == upper) {
                list.add(String.valueOf(upper));
            } else {
                list.add(String.valueOf(nums[nums.length - 1] + 1) + "->" + String.valueOf(upper));
            }
        }
        
        return list;
        
    }
}
