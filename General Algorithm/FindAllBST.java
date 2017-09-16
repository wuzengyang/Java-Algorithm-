package laiOfferTest;

public class FindAllBST {
	
	public static void main(String[] args) {
		int n = 19;
		System.out.println(numOfTrees(n));
		System.out.println(numOfTrees2(n));
		
	}

	public static int numOfTrees(int n) {
		// Write your solution here.
		if (n <= 0) {
			return 1;
		}
		int[][] result = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			result[i][i] = 1;
		}
		
		for (int count = 1; count < n; count++) {
			for (int i = 1; i + count <= n; i++) {

				// while count >= 1
				// add the first one and the last one
				result[i][i + count] += result[i][i] * result[i + 1][i + count];
				result[i][i + count] += result[i][i + count - 1]
						* result[i + count][i + count];
				for (int j = i + 1; j < i + count; j++) {
					result[i][i + count] += result[i][j - 1] * result[j][j]
							* result[j + 1][i + count];
				}
		
			}
		}
		
/*		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}*/
		return result[1][n];

	}
	
	public static int numOfTrees2(int n) {
		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				result[i] += result[j] * result[1] * result[i - 1 - j];
			}
		}
		return result[n];

	}

}
