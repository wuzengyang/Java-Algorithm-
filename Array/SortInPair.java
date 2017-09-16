package array;

public class SortInPair {
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		sortInPair(test);
		for (int temp : test) {
			System.out.print(temp + ", ");
		}
	}

	public static void sortInPair(int[] array) {
		// Write your solution here.
		if (array == null || array.length <= 1) {
			return;
		}

		if (array[0] > array[1]) {
			swap(array, 0, 1);
		}

		for (int i = 2; i < array.length; i++) {
			if ((array[i] > array[i - 1] && array[i - 1] > array[i - 2])
					|| (array[i] < array[i - 1] && array[i - 1] < array[i - 2])) {
				swap(array, i, i - 1);
			}
		}

		return;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
