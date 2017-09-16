package array;

public class WiggleSort {
	
	public static void main(String[] args) {
		int[] test = {7, 5, 7, 9 ,3};
//		int[] test = {4, 8, 8, 2};
		wiggleSort(test);
		
		for (int temp : test) {
			System.out.print(temp + ", ");
		}
	}
	
	
    public static void wiggleSort(int[] nums) {
        
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        if (nums[0] > nums[1]) {
            swap(nums, 0, 1);
        }
        
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0 && (nums[i] >= nums[i - 1] && nums[i - 1] >= nums[i - 2])) {
                swap(nums, i, i - 1);
            }
            
            if (i % 2 == 1 && (nums[i] <= nums[i - 1] && nums[i - 1] <= nums[i - 2])) {
                swap(nums, i, i - 1);
            }
        }
        
        return;
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
