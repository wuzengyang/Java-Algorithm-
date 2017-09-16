package array;

import java.util.Arrays;

public class MaximumAverageSubarrayII {
	
	public static void main(String[] args) {
		int[] test = {1,12,-5,-6,50,3};
		int k = 4;
		System.out.println(findMaxAverage(test, k));
	}
	
	
    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0.0;
        }
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < k; i++) {
            sum += copy[copy.length - 1 - i];
        }
        
        avg = (double) sum / (double) k;
        
        System.out.println("count = " + k + ". avg is " +avg);
        int index = copy.length - k - 1;
        while (copy[index] > 0) {
            sum += copy[index];
            avg = Math.max(avg, (double) sum / (double) (copy.length - index));
            System.out.println("count = " + (copy.length - index) + ". avg is " +avg);
        }
        
        return avg;
    }

}
