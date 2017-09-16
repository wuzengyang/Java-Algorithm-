package laiOfferTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;

public class PlaceToPutTheChairI {
	
	public static void main(String[] args) {
/*		char[][]  test = { 	{ 'C', 'C', 'C', 'C' },

							{ 'C', 'O', 'E', 'C' },

							{ 'C', 'C', 'O', 'C' },
				  			
							{ 'C', 'E', 'C', 'C' }};*/
     	char[][]  test = { 	{ 'E', 'C', 'E', 'O', 'C' },

     						{ 'E', 'O', 'C', 'C', 'E' },

     						{ 'O', 'O', 'E', 'C', 'C' },
     						
     						{ 'C', 'O', 'C', 'E', 'E' },
			
     						{ 'E', 'C', 'C', 'C', 'C' }};
		//char[][] test = {{'O'}};
		List<Integer> result = putChair(test);
		System.out.print(result);
	}
	
	public static List<Integer> putChair(char[][] gym) {
	
		if (gym == null) {
			return null;
		}
		
		//step one, find out the location of equipment and obstacles
		int N = gym.length;
		int M = gym[0].length;
		int[][] result = new int[N][M];
		Set<List<Integer>> check = new HashSet<>();
		List<List<Integer>> eqm = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (gym[i][j] == 'E') {
					eqm.add(Arrays.asList(i, j));
//					check.add(Arrays.asList(i, j));
					result[i][j] = Integer.MAX_VALUE;
				}
				if (gym[i][j] == 'O') {
					check.add(Arrays.asList(i, j));
					result[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		// run dijkstra for each equipment
		
		
		for (int i = 0; i < eqm.size(); i++) {
			List<Integer> temp = eqm.get(i);
			int[][] each = dijkstra(temp, check, N, M); 
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (each[j][k] == Integer.MAX_VALUE || result[j][k] == Integer.MAX_VALUE) {
						result[j][k] = Integer.MAX_VALUE;
					} else {
						result[j][k] += each[j][k];
					}
				}
			}
		}
		
		int row = 0;
		int col = 0;
		int globalMin = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (globalMin > result[i][j]) {
					globalMin = result[i][j];
					row = i;
					col = j;
				}
			}
		}
		return globalMin == Integer.MAX_VALUE? null : Arrays.asList(row, col);
	}	
	
	public static int[][] dijkstra(List<Integer> location, Set<List<Integer>> check, int N, int M) {
		int row = location.get(0);
		int col = location.get(1);
		int[][] result = new int[N][M];
		result[row][col] = Integer.MAX_VALUE;
		Set<List<Integer>> visited = new HashSet<>();
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		
		// begin to expand: right, bottom, left, and top
		if (col + 1 < M && !check.contains(Arrays.asList(row, col + 1))) {
			minHeap.offer(new Node(row, col + 1, 1));
			visited.add(Arrays.asList(row, col + 1));
			result[row][col + 1] = 1;
		}
		if (row + 1 < N && !check.contains(Arrays.asList(row + 1, col))) {
			minHeap.offer(new Node(row + 1, col, 1));
			visited.add(Arrays.asList(row + 1, col));
			result[row + 1][col] = 1;
		}
		if (col - 1 >=  0 && !check.contains(Arrays.asList(row, col - 1))) {
			minHeap.offer(new Node(row, col - 1, 1));
			visited.add(Arrays.asList(row, col - 1));
			result[row][col - 1] = 1;
		}
		if (row - 1 >= 0 && !check.contains(Arrays.asList(row - 1, col))) {
			minHeap.offer(new Node(row - 1, col, 1));
			visited.add(Arrays.asList(row - 1, col));
			result[row - 1][col] = 1;
		}
		
		// begin loop
		while(!minHeap.isEmpty()) {
			Node temp = minHeap.poll();
			int x = temp.x;
			int y = temp.y;
			// begin to generate: right, bottom, left, up
			if (y + 1 < M && !check.contains(Arrays.asList(x, y + 1)) && !visited.contains(Arrays.asList(x, y + 1))) {
				minHeap.offer(new Node(x, y + 1, temp.cost + 1));
				visited.add(Arrays.asList(x, y + 1));
				result[x][y + 1] = temp.cost + 1;
			}
			if (x + 1 < N && !check.contains(Arrays.asList(x + 1, y)) && !visited.contains(Arrays.asList(x + 1, y))) {
				minHeap.offer(new Node(x + 1, y, temp.cost + 1));
				visited.add(Arrays.asList(x + 1, y));
				result[x + 1][y] = temp.cost + 1;
			}
			if (y - 1 >= 0 && !check.contains(Arrays.asList(x, y + 1)) && !visited.contains(Arrays.asList(x, y - 1))) {
				minHeap.offer(new Node(x, y - 1, temp.cost + 1));
				visited.add(Arrays.asList(x, y - 1));
				result[x][y - 1] = temp.cost + 1;
			}
			if (x - 1 >= 0 && !check.contains(Arrays.asList(x - 1, y)) && !visited.contains(Arrays.asList(x - 1, y))) {
				minHeap.offer(new Node(x - 1, y, temp.cost + 1));
				visited.add(Arrays.asList(x - 1, y));
				result[x - 1][y] = temp.cost + 1;
			}
		}
		return result;
	}
	
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override 
		public int compareTo(Node another) {
			if (this.cost == another.cost) {
				return 0;
			}
			return this.cost < another.cost? -1 : 1;
		}
	}
}
