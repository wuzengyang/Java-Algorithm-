package array;

public class SearchInShiftedSorteArrayII {
	
	

	public static void main(String[] args) {
		int[] test = {1, 2, 3, 3, 3, 4};
		int t = 2;
		System.out.println(search(test, t));
	}

	public static int search(int[] array, int target) {
		// Write your solution here
		// use binary search
		if (array == null || array.length == 0) {
			return -1;
		}

		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			}
			
			if (array[mid] == array[left] && array[mid] == array[right]) {
				right--;
				continue;
			}
			System.out.println("before: " + mid + ", " + left + ", " + right);


			if (array[mid] > target) {
				if (array[left] <= target || array[left] > array[mid]) { // right
																		// side
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (array[right] >= target || array[right] < array[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			System.out.println("After " + mid + ", " + left + ", " + right);
		}
		System.out.println();
		return -1;
	}

}
