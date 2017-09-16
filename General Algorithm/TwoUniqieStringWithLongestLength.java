package laiOfferTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class TwoUniqieStringWithLongestLength {
	public static void main(String[] args) {
		String[] test = {"a","b","c","def","fhiop","lmnu","xyzwu","rstu"};
		//String[] test = {"aaaaa", "abbb","ccc","dd"};
		//String[] result = findLargestProduct(test);
		//System.out.println(result.length);
		//System.out.println(result[0] + ", " + result[1]);
		System.out.println(findLargestProduct(test));
	}

	
	public static int findLargestProduct(String[] dict) {
		if (dict == null || dict.length <= 1) {
			return 0;
		}
		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare(String s0, String s1) {
				if (s0.length() == s1.length()) {
					return 0;
				}
				return s0.length() < s1.length()? 1 : -1;
			}
		});
		Queue<Integer[]> queue = new LinkedList<>();
		queue.offer(new Integer[] {0, 1} );
		int indexOne = 0;
		int indexTwo = 0;
		int globalMax = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			// expand check area
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer[] temp = queue.poll();
				if (checkUnique(dict, temp)) {
					if (globalMax < dict[temp[0]].length() * dict[temp[1]].length()) {
						globalMax = dict[temp[0]].length() * dict[temp[1]].length();
						indexOne = temp[0];
						indexTwo = temp[1];
					}
				} else {
					if (temp[0] + 1 < dict.length) {
						queue.offer(new Integer[] {temp[0] + 1, temp[1]});
					}
					if (temp[1] + 1 < dict.length) {
						queue.offer(new Integer[] {temp[0], temp[1] + 1});
					}
				}
			}
			//Stop loop once we find and result
			if (globalMax != Integer.MIN_VALUE) {
				return dict[indexOne].length() * dict[indexTwo].length();
			}
		}
		return globalMax == Integer.MIN_VALUE? 0 : globalMax;
	}
	
/*	public static int findLargestProduct(String[] dict) {
		if (dict == null || dict.length <= 1) {
			return 0;
		}
		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare(String s0, String s1) {
				if (s0.length() == s1.length()) {
					return 0;
				}
				return s0.length() < s1.length()? 1 : -1;
			}
		});
		Queue<Integer[]> queue = new LinkedList<>();
		queue.offer(new Integer[] {0, 1} );
		int indexOne = 0;
		int indexTwo = 0;
		int globalMax = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			// expand check area
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer[] temp = queue.poll();
				if (checkUnique(dict, temp)) {
					if (globalMax < dict[temp[0]].length() * dict[temp[1]].length()) {
						globalMax = dict[temp[0]].length() * dict[temp[1]].length();
						indexOne = temp[0];
						indexTwo = temp[1];
					}
				} 
					if (temp[0] + 1 < dict.length) {
						queue.offer(new Integer[] {temp[0] + 1, temp[1]});
					}
					if (temp[1] + 1 < dict.length) {
						queue.offer(new Integer[] {temp[0], temp[1] + 1});			
				}
			}
		}
		return globalMax == Integer.MIN_VALUE? 0 : globalMax;
	}
	*/
	public static boolean checkUnique(String[] dict, Integer[] index) {
		String a = dict[index[0]];
		String b = dict[index[1]];
		int bitMap = 0;
		
		for (char temp : a.toCharArray()) {
				bitMap = bitMap | (1 << temp);
		}
		for (char temp2 : b.toCharArray()) {
			if ((bitMap & (1 << temp2)) != 0) {
				return false;
			}
		}
		return true;
	}
}
