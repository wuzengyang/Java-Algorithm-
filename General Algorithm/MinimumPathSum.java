package laiOfferTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] test = { { 5, 1, 2, 4 }, { 4, 1, 0, 1 }, { 0, 3, 7, 6 } };
		System.out.println(miniSum(test));
		System.out.println(miniSum2(test));
		System.out.println(miniSum3(test));
	}

	public static int miniSum(int[][] grid) {
		// Input your code here
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int N = grid.length;
		int M = grid[0].length;
		int[][] result = new int[N][M];
		PriorityQueue<Element> minHeap = new PriorityQueue<>();
		// initialize minHeap and result matrix
		result[0][0] = grid[0][0];
		minHeap.offer(new Element(0, 0, result[0][0]));
		boolean[][] check = new boolean[N][M];
		check[0][0] = true;

		while (!minHeap.isEmpty()) {
			// expand
			Element temp = minHeap.poll();

			int row = temp.row;
			int col = temp.col;

			System.out.println("now poll: " + temp.value + ", at row: " + row
					+ ", col : " + col);
			// generate
			if (row + 1 < N && !check[row + 1][col]) {

				minHeap.offer(new Element(row + 1, col, temp.value
						+ grid[row + 1][col]));
				result[row + 1][col] = temp.value + grid[row + 1][col];
				check[row + 1][col] = true;

			}
			if (col + 1 < M && !check[row][col + 1]) {
				minHeap.offer(new Element(row, col + 1, temp.value
						+ grid[row][col + 1]));
				result[row][col + 1] = temp.value + grid[row][col + 1];
				check[row][col + 1] = true;
			}
		}

		return result[N - 1][M - 1];
	}
	
	public static int miniSum2(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int N = grid.length;
		int M = grid[0].length;
		int[][] result = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (j == 1) {
					result[i][j] = grid[i - 1][j - 1] + result[i - 1][j]; 
				} else if (i == 1) {
					result[i][j] = grid[i - 1][j - 1] + result[i][j - 1]; 
				} else {
					result[i][j] = grid[i - 1][j - 1] + Math.min(result[i - 1][j], result[i][j - 1]);
				}
			}
		}
		return result[N][M];
	}
	
	public static int miniSum3(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int N = grid.length;
		int M = grid[0].length;
		int[] result = new int[M];
		for (int i = 0; i < N; i++) {
			int[] preResult = Arrays.copyOf(result, M);
			for (int j = 0; j < M; j++) {
				if (j == 0) {
					result[j] = grid[i][j] + preResult[j]; 
				} else if (i == 0) {
					result[j] = grid[i][j] + result[j - 1]; 
				} else {
					result[j] = grid[i][j] + Math.min(preResult[j], result[j - 1]);
				}
			}
		}
		return result[M - 1];
	}

	public static class Element implements Comparable<Element> {
		int row;
		int col;
		int value;

		public Element(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}

		@Override
		public int compareTo(Element b) {
			if (this.value == b.value) {
				return 0;
			}

			return this.value < b.value ? -1 : 1;
		}
	}

}
