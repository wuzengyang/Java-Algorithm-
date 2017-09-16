package laiOfferTest;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSequence {

	public static void main(String[] args) {
		String s = "abcde";
		String t = "ammbitititcmme";
		System.out.println(longest(s, t));
	}

	public static List<Character> longest(String s, String t) {
		// Write your solution here.
		if (s.length() == 0 || t.length() == 0) {
			return new ArrayList<Character>();
		}
		int N = s.length();
		int M = t.length();
		int globalMax = Integer.MIN_VALUE;
		List<Character> sequence = new ArrayList<>();
		int[][] result = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					result[i][j] = result[i - 1][j - 1] + 1;
				} else {
					result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
				}
				if (globalMax < result[i][j]) {
					globalMax = result[i][j];
					sequence.add(s.charAt(i - 1));
				}
			}
		}
		// return result[N][M];
		return sequence;
	}
}
