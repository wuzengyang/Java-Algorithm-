package array;

import java.util.Arrays;

public class ThreeSumSmaller {
	
	public static void main(String[] args) {
		int[] test = {1,-2,2,1,0};
		int t = 1;
		System.out.println(threeSumSmaller(test, t));
	}
	
	
    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        if (3 * copy[0] > target) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < copy.length - 2; i++) {
            if (copy[i] * 3 > target) {
                return count;
            }
            
            int left = i + 1;
            int right = copy.length - 1;
            while (left < right) {
                int temp = copy[i] + copy[left] + copy[right];
                if (temp >= target) {
                    right--;
                } else {
                    count += right - left;
                    left++;
                }
            }
        }
        
        return count;
        
    }

}
