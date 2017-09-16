package array;

public class RainbowSortIII {
	
	public static void main(String[] args) {
		int[] test = {1,3,2,1,1,2};
		int k = 3;
		int[] result = rainbowSortIII(test, k);
		for (int temp : result) {
			System.out.print(temp + ", ");
		}
		
	}

	public static int[] rainbowSortIII(int[] array, int k) {
		// Write your solution here.
		if (array == null || array.length <= 1) {
			return array;
		}
		// first sort 0 and 3
		int left = 0;
		int right = array.length - 1;
		int check = 0;
		int value = 1;
		while (left <= right) {
			check = left;
			while (check <= right) {
				if (array[check] == value) {
					swap(array, left, check);
					left++;
				} else if (array[check] == k + 1 - value) {
					swap(array, right, check);
					right--;
				} else {
					check++;
				}
				check = Math.max(check, left);
			}
			value++;
		}

		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
