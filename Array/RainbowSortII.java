package array;

public class RainbowSortII {
	
	public static void main(String[] args) {
		int[] test = {1,3,2,0,0,2};
		int[] result = rainbowSortII(test);
//		for (int temp : result) {
//			System.out.print(temp + ", ");
//		}
		
	}

	public static int[] rainbowSortII(int[] array) {
		// Write your solution here.
		if (array == null || array.length <= 1) {
			return array;
		}

		// first sort 0 and 3
		int left = 0;
		int right = array.length - 1;
		int check = 0;

		while (check <= right) {
			if (array[check] == 0) {
				swap(array, left, check);
				left++;
			} else if (array[check] == 3) {
				swap(array, right, check);
				right--;
			} else {
				check++;
			}
			check = Math.max(check, left);
		}
		
		System.out.println("After sorting 0 and 3, left is " + left + ", and right is " + right);
		for (int temp : array) {
			System.out.print(temp + ", ");
		}
		System.out.println();

		// then sort 1 and 2;
		check = left;
		while (left <= right) {
			if (array[left] == 2) {
				swap(array, left, right);
				right--;
			} else {
				left++;
			}
			
		}
		
		System.out.println("After sorting 1 and 2");
		for (int temp : array) {
			System.out.print(temp + ", ");
		}
		System.out.println();
		return array;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
