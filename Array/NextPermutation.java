package array;

public class NextPermutation {

	public static void main(String[] args) {
		int[] test = {2,2,7,5,4,3,2,2,1};
		int[] result = nextPermutation(test);
		for (int i : result) {
			System.out.print(i + ", ");
		}
	}

	public static int[] nextPermutation(int[] nums) {

		if (nums == null || nums.length == 0) {
			return nums;
		}

		int start = nums.length - 1;
		int end = nums.length - 1;
		for (int i = nums.length - 1; i >= 1; i--) {
			if (nums[i - 1] >= nums[i]) {
				start--;
			} else {
				System.out.println("Now swap at i = " + i);
				int index = findLarger(nums, start, end, nums[i - 1]);
				System.out.println("we need swap at index of " + index);
				swap(nums, i - 1, index);
				reverse(nums, start, end);
				return nums;
			}
		}
		
		System.out.println("final reverse?");
		reverse(nums, 0, nums.length - 1);
		return nums;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void reverse(int[] array, int left, int right) {
		while (left < right) {
			swap(array, left++, right--);
		}
	}

	public static int findLarger(int[] array, int left, int right, int target) {
		int l = left;
		int r = right;
		while (l < r - 1) {
			int mid = l + (r - l) / 2;
			if (array[mid] > target) {
				l = mid;
			} else {
				r = mid;
			}
		}

		return array[r] > target ? r : l;
	}

}
