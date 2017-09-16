package laiOfferTest;

public class InterleaveStrings {
	public static void main(String[] args) {
		String a = "abgcd";
		String b = "bebgf";
		String c = "babebggcfd";
		System.out.println(canMerge(a, b, c));
	}

	public static boolean canMerge(String a, String b, String c) {
		// Write your solution here.
		// Must avoid duplications
		// Try recursion
/*		if (c.length() != (a.length() + b.length())) {
			System.out.println("run time error: length cannot match");
			return false;
		}
		return checkMerge(a, 0, b, 0, c, 0);*/
		
	    if (c.length() != (a.length() + b.length())) {
		  	return false;
		  }
	    boolean[][] result = new boolean[a.length() + 1][b.length() + 1];
	    for (int i = 0; i <= a.length(); i++) {
	      for (int j = 0; j <= b.length(); j++) {
	        if (i == 0 && j == 0) {
	          result[i][j] = true;
	        }
	        if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
	          result[i][j] = result[i - 1][j];
	        }
	        if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
	          result[i][j] = result[i][j - 1] || result[i][j];
	        }
	      }
	    }
	    return result[a.length()][b.length()];
	}

	public static boolean checkMerge(String a, int indexA, String b,
			int indexB, String c, int indexC) {
		// termination condition
		if (indexA == a.length() && indexB == b.length()
				&& indexC == c.length()) {
			return true;
		}

		// actions in this layer
		// case 1: c = a and c == b
		if (indexA < a.length() && indexB < b.length()) {
			if (c.charAt(indexC) == a.charAt(indexA)
					&& c.charAt(indexC) == b.charAt(indexB)) {
				return checkMerge(a, indexA + 1, b, indexB, c, indexC + 1)
						|| checkMerge(a, indexA, b, indexB + 1, c, indexC + 1);
			} else if (c.charAt(indexC) == a.charAt(indexA)) {
				return checkMerge(a, indexA + 1, b, indexB, c, indexC + 1);
			} else if (c.charAt(indexC) == b.charAt(indexB)) {
				return checkMerge(a, indexA, b, indexB + 1, c, indexC + 1);
			} else {
				return false;
			}
		} else if (indexA < a.length()) {
			if (c.charAt(indexC) == a.charAt(indexA)) {
				return checkMerge(a, indexA + 1, b, indexB, c, indexC + 1);
			} else {
				return false;
			}
		} else {
			if (c.charAt(indexC) == b.charAt(indexB)) {
				return checkMerge(a, indexA, b, indexB + 1, c, indexC + 1);
			} else {
				return false;
			}
		}

	}
}
