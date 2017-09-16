package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuyStockIV {
	
	public static void main(String[] args) {
		int[] test = {3,4,1,2,6,2,3,5,1,7,3,8};
		int k = 1;
		System.out.print(maxProfit(test, k));
	}

	public static int maxProfit(int[] array, int k) {
		// write your solution here
		if (array == null || array.length <= 1) {
			return 0;
		}

		List<Integer> list = new ArrayList<>();
		int start = 0;
		int end = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[i] >= array[i - 1]) {
				end++;
			} else {
				if (array[end] - array[start] > 0) {
					list.add(array[end] - array[start]);
				}
				start = i;
				end = i;
			}
		}

		list.add(array[end] - array[start]);
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		Arrays.sort(result);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(result[i] + ", ");
		}
		System.out.println();
		
		int count = 0;
		int index = result.length - 1;
		int max = 0;
		while (index >= 0 && count < k) {
			max += result[index];
			index--;
			count++;
		}
		return max;
	}
}
