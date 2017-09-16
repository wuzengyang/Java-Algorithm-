package laiOfferTest;

public class TwoSubsetsWithMinDifference {
	
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5,6,7,8,9};
		System.out.println(minDifference(test));
	}
	
	public static int minDifference(int[] array) {
		// Write your solution here.
		// Similar with all subsets questions
		// just need to calculate curSum at each recursion call
	  // Time O(n!)
		int arraySum = 0;
		for (int temp : array) {
			arraySum += temp;
		}

		int[] globalMin = new int[1];
		globalMin[0] = Integer.MAX_VALUE;
		helper(array, 0, 0, 0, globalMin, arraySum);
		return globalMin[0];
	}

	public static void helper(int[] array, int index,  int curSum, int count,
			int[] globalMin, int arraySum) {
		// terminate condition
		if (index >= array.length) {
			if (count == array.length / 2) {
				  globalMin[0] = Math.min(globalMin[0], Math.abs(arraySum - 2 * curSum));
			}
			return;
		}
		
		curSum = curSum + array[index];
		helper(array, index + 1, curSum, count + 1, globalMin, arraySum);
		curSum =curSum - array[index];
		helper(array, index + 1, curSum, count, globalMin, arraySum);

	}

}
