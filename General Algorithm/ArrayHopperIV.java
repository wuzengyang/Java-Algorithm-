package laiOfferTest;

public class ArrayHopperIV {

	public static void main(String[] args) {
		// int[] test = {3, 3, 1, 0, 0};
		// int[] test = {1, 3, 1, 2, 2};
		int[] test = { 6, 0, 2, 0, 1, 0, 4 };
		System.out.println(minJump(test, 4));
	}

	public static int minJump(int[] array, int index) {
		// write your solution here
		// Assume array is not null and has length larger than 0
		if (array.length == 1) {
			return 0;
		}

		if (index < 0 || index >= array.length) {
			return -1;
		}

		// now we can do array hopper II twise
		// first loop, do the whole array
		// If at index it cannot reach right end, result[index] = -1;
		int[] resultOne = findPathRight(array, 0, array.length - 1);
		int[] resultTwo = new int[index + 1];
		for (int i = 0; i <= index; i++) {
			resultTwo[i] = findPathLeft(array, i, index);
		}

		int globalMin = Integer.MAX_VALUE;
		for (int i = 0; i <= index; i++) {
			// just consider when we could update globalMin
			// case one: r1[index] != -1, r1[i] != -1 and r2[i]!= -1
			if (resultOne[index] != -1 && resultOne[i] != -1
					&& resultTwo[i] != -1) {
				globalMin = Math
						.min(globalMin,
								Math.min(resultOne[index], resultOne[i]
										+ resultTwo[i]));
			} else if (resultOne[index] != -1
					&& (resultOne[i] == -1 || resultTwo[i] == -1)) {
				// case two: ri[index != -1 but r1[i] = -1 || r2[i] == -1]
				globalMin = Math.min(globalMin, resultOne[index]);
			} else if (resultOne[index] == -1
					&& (resultOne[i] != -1 && resultTwo[i] != -1)) {
				// case three: r1[index] == -1 but r1[i] & r2[i] != -1
				globalMin = Math.min(globalMin, resultOne[i] + resultTwo[i]);
			}
		}
		return globalMin == Integer.MAX_VALUE ? -1 : globalMin;
	}

	public static int[] findPathRight(int[] array, int left, int right) {
		int[] result = new int[Math.abs(right - left + 1)];

		for (int i = right - 1; i >= left; i--) {
			if ((array[i] + i) >= result.length - 1) {
				result[i - left] = 1;
			} else {
				int globalMin = Integer.MAX_VALUE;
				for (int j = 1; j <= array[i]; j++) {
					if (result[i + j] != -1) {
						globalMin = Math.min(globalMin, result[i + j] + 1);
					}
				}
				result[i - left] = globalMin == Integer.MAX_VALUE ? -1
						: globalMin;
			}
		}

		return result;
	}

	public static int findPathLeft(int[] array, int left, int right) {
		int[] result = new int[Math.abs(right - left + 1)];

		for (int i = left + 1; i <= right; i++) {
			if (i - array[i] <= left) {
				result[i - left] = 1;
			} else {
				int globalMin = Integer.MAX_VALUE;
				for (int j = 1; j <= array[i]; j++) {
					if (result[i - j - left] != -1) {
						globalMin = Math.min(globalMin, result[i - j] + 1);
					}
				}
				result[i - left] = globalMin == Integer.MAX_VALUE ? -1
						: globalMin;
			}
		}
		return result[right - left];
	}
}
