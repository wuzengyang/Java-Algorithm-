package laiOfferTest;

import java.util.PriorityQueue;

public class MaxWaterTrappedII {
	
	public static void main(String[] args) {
		int[][] test = { { 10, 10, 8, 10 },

				  { 10, 1, 2, 10 },
				  
				  { 10, 9, 5, 10 },

				  { 10, 10, 10, 10 } };
/*		int[][] test = {{1,9,2,5,8,4},
						{2,4,5,1,3,2},
						{7,1,3,5,6,6},
						{8,5,9,3,3,4},
						{5,2,1,7,5,7}};*/
		System.out.println(maxTrapped(test));
	}

	public static int maxTrapped(int[][] matrix) {
		// Write your solution here.
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		// use a min-heap to find the lowest level position
		PriorityQueue<Element> minHeap = new PriorityQueue<>();

		// Step one: offer all points into min-heap
		int N = matrix.length;
		int M = matrix[0].length;
		Element[][] points = new Element[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
					points[i][j] = new Element(i, j, matrix[i][j]);
					minHeap.offer(points[i][j]);
				} else {
					points[i][j] = new Element(i, j, Integer.MAX_VALUE);
				}
				 // ensure we can pass by reference
			}
		}

		// then begin to pop out
		int sum = 0;
		while (!minHeap.isEmpty()) {
			Element temp = minHeap.poll();
			int i = temp.row;
			int j = temp.col;
			sum += points[i][j].level - matrix[i][j]; // update reserved
/*			if (points[i][j].level - matrix[i][j] > 0) {
				System.out.println("the row is: " + i);
				System.out.println("the col is: " + j);
				System.out.println("the value is: " + (points[i][j].level - matrix[i][j]));
				System.out.println();
				
			}*/
															// water
			// then begin to generate : top, bottom, left, right
			if (i - 1 >= 0) {
				int tempLevel = Math.max(matrix[i - 1][j],
						Math.min(points[i - 1][j].level, points[i][j].level));
				if (points[i - 1][j].level != tempLevel) {
					points[i - 1][j].level = tempLevel;
					minHeap.offer(points[i - 1][j]);
				}
			}
			if (i + 1 < N) {
				int tempLevel = Math.max(matrix[i + 1][j],
						Math.min(points[i + 1][j].level, points[i][j].level));
				if (points[i + 1][j].level != tempLevel) {
					points[i + 1][j].level = tempLevel;
					minHeap.offer(points[i + 1][j]);
				}
			}
			if (j - 1 >= 0) {
				int tempLevel = Math.max(matrix[i][j - 1],
						Math.min(points[i][j - 1].level, points[i][j].level));
				if (points[i][j - 1].level != tempLevel) {
					points[i][j - 1].level = tempLevel;
					minHeap.offer(points[i][j - 1]);
				}
			}
			if (j + 1 < M) {
				int tempLevel = Math.max(matrix[i][j + 1],
						Math.min(points[i][j + 1].level, points[i][j].level));
				if (points[i][j + 1].level != tempLevel) {
					points[i][j + 1].level = tempLevel;
					minHeap.offer(points[i][j + 1]);
				}
			}
		}
		return sum;
	}

	public static class Element implements Comparable<Element> {
		int row;
		int col;
		int level;

		public Element(int row, int col, int level) {
			this.row = row;
			this.col = col;
			this.level = level;
		}

		@Override
		public int compareTo(Element another) {
			if (this.level == another.level) {
				return 0;
			}
			return this.level < another.level ? -1 : 1;
		}
	}

}
