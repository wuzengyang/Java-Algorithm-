package DP;

import java.util.Arrays;

public class TargetSum {
	
	public static void main(String[] args) {
		int[] test = {1, 1, 1, 1, 1};
		System.out.println(findTargetSumWays(test, 3));
	}
	
	
    public static int findTargetSumWays(int[] nums, int S) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int temp : nums) {
            sum += temp;
        }
        
        if (sum < Math.abs(S)) {
            return 0;
        }
        
        // use two array to simulate possitive and negtive value combinations
        int[] poz = new int[sum + 1];  // restore all poz curSum 
        int[] neg = new int[sum + 1];  // restore all neg curSum
        poz[0] = 1;
        neg[0] = 1;
		for (int i = 1; i <= nums.length; i++) {
			int[] prePoz = Arrays.copyOf(poz, sum + 1);
			int[] preNeg = Arrays.copyOf(neg, sum + 1);
			
			
            for (int j = 0; j <= sum; j++) {
                // case one : choose + 
            	poz[j] = 0;
            	neg[j] = 0;
                if (j - nums[i - 1] >= 0) {
                    poz[j] += prePoz[j - nums[i - 1]]; // choose +
                    neg[j] += prePoz[j - nums[i - 1]]; // choose -
                } else {
                    poz[j] += preNeg[nums[i - 1] - j]; // choose +
                    neg[j] += preNeg[nums[i - 1] - j]; // choose -;
                }
                neg[j] += j + nums[i - 1] <= sum ? preNeg[j + nums[i - 1]] : 0; // choose -
                poz[j] += j + nums[i - 1] <= sum? prePoz[j + nums[i - 1]] : 0; // choose +
            }
            
        System.out.println("now poz : ");    
        for (int k = 0; k < poz.length; k++) {
        		System.out.print(poz[k] + ", ");
        }
        System.out.println();
         System.out.println("now neg: ");
        for (int k = 0; k < neg.length; k++) {
        		System.out.print(neg[k] + ", ");
        }
        System.out.println();
        System.out.println("Finished with i =  " + i);
        System.out.println();
            
        }
        

        
        
        return S >= 0? poz[S] : neg[-S];
        
    }

}
