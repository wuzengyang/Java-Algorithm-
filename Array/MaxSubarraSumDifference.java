package array;

public class MaxSubarraSumDifference {
	
	public static void main(String[] args) {
		int[] test = { 1, -3, 1, -4, 3, 4 };
		System.out.println(maxDiff(test));
	}

/*	public static int maxDiff(int[] array) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return 0;
		}

		if (array.length == 1) {
			return array[0];
		}
		int size = array.length;
		int[] sum = new int[array.length];
		sum[0] = array[0];
		for (int i = 1; i < size; i++) {
			sum[i] = array[i] + sum[i - 1];
		}
		int maxDiff = Integer.MIN_VALUE;

		int[][] result = new int[size][size];
		for (int len = 0; len < array.length; len++) {
			for (int i = 0; i + len < array.length; i++) {
				if (len == 0) {
					result[i][i + len] = array[i];
				} else {
					int curMax = Integer.MIN_VALUE;
					for (int j = i; j < i + len; j++) {
						int left = sum[j] - sum[i] + array[i];
						int right = sum[i + len] - sum[j + 1] + array[j + 1];
						curMax = Math.max(curMax, Math.abs(left - right));
					}
					result[i][i + len] = curMax;
					maxDiff = Math.max(curMax, maxDiff);
				}
			}
		}

		return maxDiff;
	}*/
	
	public static int maxDiff(int[] array) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return 0;
		}

		if (array.length == 1) {
			return array[0];
		}
		int size = array.length;
		int[] leftMax = new int[size];
		int[] leftMin = new int[size];
		int[] rightMax = new int[size];
		int[] rightMin = new int[size];
		
		int curMax = Integer.MIN_VALUE;
		int curMin = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			curMax = curMax < 0 ? array[i] : curMax + array[i];
			curMin = curMin > 0 ? array[i] : curMin + array[i];
			leftMax[i] = curMax;
			leftMin[i] = curMin;
		}
		
		curMax = Integer.MIN_VALUE;
		curMin = Integer.MAX_VALUE;
		for (int i = size - 1; i >= 0; i--) {
			curMax = curMax < 0 ? array[i] : curMax + array[i];
			curMin = curMin > 0 ? array[i] : curMin + array[i];
			rightMax[i] = curMax;
			rightMin[i] = curMin;
		}
		
		int maxDif = Integer.MIN_VALUE;
		for (int i = 0; i < size - 1; i++) {
			maxDif = Math.max(maxDif, Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), 
							Math.abs(leftMin[i] - rightMax[i + 1])));
		}
		
		return maxDif;
		
		

	}

}
