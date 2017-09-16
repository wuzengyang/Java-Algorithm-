package laiOfferTest;

public class LongestCommonSubString {
	
	public static void main(String[] args) {
		String s = "abcde";
		String t = "mmbcdff";
		System.out.print(longestCommon(s, t));
	}
	public static String longestCommon(String s, String t) {
		// Write your solution here.
		// assume both s and t are not null
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}
		int N = s.length();
		int M = t.length();
		int[][] result = new int[N][M];
		int globalMax = Integer.MIN_VALUE;
		int location = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					if (i == 0 || j == 0) {
						result[i][j] = 1;
					} else {
						result[i][j] = result[i - 1][j - 1] + 1;
					}
					
					if (globalMax < result[i][j]) {
						globalMax = result[i][j];
						location = i;
					}
				}
			}
		}
		// now we have globalMax and location

		return globalMax == Integer.MIN_VALUE ? "" : s.substring(location
				- globalMax + 1, location + 1);
	}

}
