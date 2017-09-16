package laiOfferTest;

import java.util.*;

public class KthClosest {
	
public static List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		
		if(k > a.length * b.length * c.length) {
			return Arrays.asList(0,0,0);
		}
		
		PriorityQueue<Coordinate> minHeap = new PriorityQueue<>(11, new Comparator<Coordinate>(){
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				if(c1.distance == c2.distance) {
					return 0;
				}
				return c1.distance < c2.distance ? -1 : 1;
			}
		});
		
		Set<Double> visited = new HashSet<>();
		
		minHeap.offer(new Coordinate(0,0,0,a,b,c));
		visited.add(minHeap.peek().distance);

		while(k > 1) {
			
			
			Coordinate temp = minHeap.poll();
			
			if(temp.i + 1 < a.length){
				Coordinate newA = new Coordinate(temp.i + 1, temp.j, temp.m, a, b, c);
				if(visited.add(newA.distance)) {
					minHeap.offer(newA);
				}
			}
			
			if(temp.j + 1 < b.length) {
				Coordinate newB = new Coordinate(temp.i, temp.j + 1, temp.m, a, b, c);
				if(visited.add(newB.distance)) {
					minHeap.offer(newB);
				}
			}
			
			if(temp.m + 1 < c.length) {
				Coordinate newC = new Coordinate(temp.i, temp.j, temp.m + 1, a, b, c);
				if(visited.add(newC.distance)) {
					minHeap.offer(newC);
				}
			}
			
			k--;
		}
		
		Coordinate cord = minHeap.peek();
		int x = a[cord.i];
		int y = b[cord.j];
		int z = c[cord.m];
		
		return Arrays.asList(x, y, z);
	}
	
	static class Coordinate {
		int i, j, m;
		int[] a, b, c;
		double distance;
		
		public Coordinate(int i, int j, int m, int[] a, int[] b, int[] c) {
			this.i = i;
			this.j = j;
			this.m = m;
			this.a = a;
			this.b = b;
			this.c = c;
			this.distance = Math.sqrt(a[i] * a[i] + b[j] * b[j] + c[m] * c[m]);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3};
		int[] B = {2,4};
		int[] C = {1,2};
		
		int k = 4;
		
		System.out.println(closest(A, B, C, k));
	}
}
