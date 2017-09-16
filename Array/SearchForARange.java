package array;

public class SearchForARange {

	public static void main(String[] args) {
		int[] test = {1, 3, 3, 3, 5, 5, 7};
		int target = 3;
		int[] r = range(test, target);
		for (int i : r) {
			System.out.print(i + ", ");
		}
	}
	
	public static int[] range(int[] array, int target) {
		// Write your solution here
		if (array == null || array.length == 0) {
			return new int[] { -1, -1 };
		}

		int left = findLeft(array, target);
		int right = findRight(array, target);

		return new int[] { left, right };
	}

	public static int findLeft(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		
		System.out.println("findLeft left and right is: " + left + ", " + right);
		if (array[left] == target) {
			return left;
		} 
		if (array[right] == target) {
			return right;
		} 
		
		return -1;
		
	}

	public static int findRight(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		if (array[right] == target) {
			return right;
		} 
		if (array[left] == target) {
			return left;
		} 
		
		return -1;
	}

}
