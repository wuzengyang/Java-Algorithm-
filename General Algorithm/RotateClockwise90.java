package laiOfferTest;

public class RotateClockwise90 {
	
	public static void main(String[] args) {
		int[][] test = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		System.out.println("Before rotate: ");
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j] + ", ");
			}
			System.out.println();
		}
		rotate(test);
		System.out.println("After rotate: ");
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j] + ", ");
			}
			System.out.println();
		}		
	}
	
	public static void rotate(int[][] matrix) {
		// Write your solution here.
		// if N == 0 || N == 1, no action needed
		// void type : in-place operation
		int N = matrix.length;
		if (N <= 1) {
			return;
		}

		helper(matrix, 0, N, N);
	}

	public static void helper(int[][] matrix, int offset, int size, int N) {
		// N is the original matirx edge size and should not be changed
		// size is the edge length of current sub-matrix

		// terminate condition
		if (size <= 1) {
			return;
		}

		// on current layer
		for (int j = 0; j < size - 1; j++) {
			// begin rotate
			int temp = matrix[offset][j + offset];
			// left bottom to left top
			matrix[offset][j + offset] = matrix[N - 1 - (j + offset)][offset];
			// right bottom to left bottom
			matrix[N - 1 - (j + offset)][offset] = matrix[N - 1
					- (offset)][N - 1 - (j + offset)];
			// right top to right bottom
			matrix[N - 1 - (offset)][N - 1 - (j + offset)] = matrix[j
					+ offset][N - 1 - (offset)];
			// left top to right top
			matrix[j + offset][N - 1 - (offset)] = temp;
		}

		// continue recursion tree
		helper(matrix, offset + 1, size - 2, N);
	}
}
