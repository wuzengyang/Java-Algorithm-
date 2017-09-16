package array;

public class InterleavePositiveAndNegativeElements {
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3, -4, -5, 6, -7, -8, -9, -10};
		int[] result = interleave(test);
		for (int temp : result) {
			System.out.print(temp + ", ");
		}
	}

	public static int[] interleave(int[] array) {
		// Write your solution here.
		if (array == null || array.length <= 1) {
			return array;
		}

		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			if (array[left] > 0) {
				left++;
			} else {
				swap(array, left, right);
				right--;
			}
		}

		if (right >= array.length / 2) {
			// poz numbers are more than neg numbers
			int neg = array.length - 1;
			int poz = right;
			while (poz >= 0 && neg > poz) {
				swap(array, poz, neg);
				neg -= 2;
				poz--;
			}
			reverse(array);
		} else {
			int poz = 1;
			int neg = left;
			while (neg < array.length && poz < neg) {
				swap(array, poz, neg);
				poz += 2;
				neg++;
			}
		}

		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] =temp;
	}

	public static void reverse(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			swap(array, left++, right--);
		}
	}

}
