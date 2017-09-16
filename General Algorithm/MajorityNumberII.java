package laiOfferTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityNumberII {
	
	public static void main(String[] args) {
		int[] test = {1,2,2,4,3,2,3,3};
		System.out.println(majority(test));
	}

	public static List<Integer> majority(int[] array) {
		// write your solution here
		if (array == null || array.length == 0) {
			return new ArrayList<Integer>();
		}

		int num1 = 0;
		int num2 = 0;
		int count1 = 0;
		int count2 = 0;

		// first loop, find two candidates that may occur more than 1/3 in this
		// array
		for (int i = 0; i < array.length; i++) {
			if (count1 == 0) {
				num1 = array[i];
				count1++;
				continue;
			}

			if (count2 == 0) {
				num2 = array[i];
				count2++;
				continue;
			}

			// now both numbers are not checked yet
			// and count1 != 0, count2!= 0
			if (array[i] == num1) {
				count1++;
			} else if (array[i] == num2) {
				count2++;
			} else {
				count1--;
				count2--;
			}
		}

		// second loop, find out the final candidate or candidates
		// case1: only one candidate
		if (num1 == num2) {
			return Arrays.asList(num1);
		}
		// case2 : num1 != num2
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num1) {
				count1++;
			}

			if (array[i] == num2) {
				count2++;
			}
		}
		if (count1 > array.length / 3 && count2 > array.length / 3) {
			return Arrays.asList(num1, num2);
		} else if (count1 > array.length / 3 || count2 > array.length / 3) {
			return count1 > count2 ? Arrays.asList(num1) : Arrays.asList(num2);
		} else {
			// still there may not be any qualified candidate
			return new ArrayList<Integer>();
		}

	}
}
