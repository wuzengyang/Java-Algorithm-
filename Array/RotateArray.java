package array;

public class RotateArray {

	public static void main(String[] args) {
		int[] test = {1, 2, 3, 4, 5};
		int k = 14;
		
		rotate(test, k);
		for (int temp : test) {
			System.out.print(temp + ", ");
		}
	}
	
    public static void rotate(int[] nums, int k) {
        
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[i - (nums.length - k)] = nums[i];
        }
        
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
        
        return;
        
    }
}
