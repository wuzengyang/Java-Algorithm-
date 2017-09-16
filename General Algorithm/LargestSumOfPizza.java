package laiOfferTest;

public class LargestSumOfPizza {
	
	public static void main(String[] args) {
		int[] test = {5, 1, 7, 4, 8, 3, 9, 2,};
		System.out.print("The max-sum is: " + findLargest(test));
	}

	
	public static int findLargest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		
		// use 2D DP
		int[][] result = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			// initialize the matrix
			result[i][i] = array[i];
		}
		
		for (int length = 0; length < array.length; length++) {
			for (int i = 0; i + length < array.length; i++) {
				if (length == 0) {
					result[i][i + length] = array[i];
				} else if (length == 1) {
					result[i][i + length] = Math.max(array[i], array[i + length]);
				} else {
					// case one: take the left pizza
					int temp1 = 0;
					int temp2 = 0;
					if (array[i + 1] > array[i + length]) {
						temp1 = array[i] + result[i + 2][i + length];
					} else {
						temp1 = array[i] + result[i + 1][i + length - 1];
					}
					//case two: take the right pizza
					if (array[i] > array[i + length - 1]) {
						temp2 = array[i + length] + result[i + 1][i + length - 1];
					} else {
						temp2 = array[i + length] + result[i][i + length - 2];
					}
					result[i][i + length] = Math.max(temp1, temp2);
				}
			}
		}
		return result[0][array.length - 1];
	}
}
