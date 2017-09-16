package DP;

public class PredictTheWinner {
	
	public static void main(String[] args) {
		int[] test = {1, 5, 2};
		System.out.println(PredictWinner(test));
	}

    public static boolean PredictWinner(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        if (nums.length == 1) {
            return true;
        }
        
        // calculate total sum
        int total = 0;
        for (int temp : nums) {
            total += temp;
        }
        
        int N = nums.length;
        int[][] result = new int[N + 1][N + 1];
        for (int len = 0; len < N; len++) {
            for (int i = 1; i + len <= N; i++) {
                if (len <= 1) {
                    result[i][i + len] = len == 0? nums[i - 1] : Math.max(nums[i - 1], nums[i]);
                } else {
                    // four different case
                    result[i][i + len] = Math.max(
                        (nums[i - 1] + Math.min(result[i + 2][i + len], result[i + 1][i + len - 1])), // choose the left element
                        (nums[i + len - 1] + Math.min(result[i + 1][i + len - 1], result[i][i + len - 2]))
                    );
                	
//                	result[i][i + len] = Math.max(nums[i- 1] + result[i + 1][i + len], nums[i + len - 1] + result[i][i + len - 1]);
                }
            }
        }
        System.out.print(result[1][N]);
        System.out.println();
        return result[1][N] >= total - result[1][N] ? true : false;
        
    }
}
