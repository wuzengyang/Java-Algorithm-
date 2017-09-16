package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public static void main(String[] args) {
		int[] test = { 1, 1, 3, 1, 3,2 ,2, 2 ,2, 5, 4, 9};
		System.out.println(majorityElement(test));
	}

	public static List<Integer> majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}

		int c1 = 0;
		int c2 = 0;
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == c1 && count1 != 0) {
				count1++;
				continue;
			}

			if (nums[i] == c2 && count2 != 0) {
				count2++;
				continue;
			}

			if (count1 == 0) {
				c1 = nums[i];
				count1++;
				continue;
			}

			if (count2 == 0) {
				c2 = nums[i];
				count2++;
				continue;
			}

			count1--;
			count2--;

		}

		System.out.println("now c1 is " + c1 + " and c2 is " + c2);
		// Now we have two candidate
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			count1 = nums[i] == c1 ? count1 + 1 : count1;
			count2 = nums[i] == c2 ? count2 + 1 : count2;
		}

		List<Integer> list = new ArrayList<>();
		System.out.println("now count1 is " + count1 + " and count2 is "
				+ count2);
		if (count1 > nums.length / 3) {
			list.add(c1);
		}

		if (c2 != c1 && count2 > nums.length / 3) {
			list.add(c2);
		}

		return list;
	}

}
