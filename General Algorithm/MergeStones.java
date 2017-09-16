package laiOfferTest;

public class MergeStones {
	
	public static void main(String[] args) {
		int[] test = {2,1,1,3,5,7,10};
		System.out.println(minCost(test));
	}
	

	public static int minCost(int[] stones) {
		// Write your solution here.
		// this is quite similar as cutting wood problem
		if (stones.length == 1) {
			return 0;
		}

		int size = stones.length;
		int[][] records = new int[size][size];
		int[] subSum = new int[size];
		subSum[0] =stones[0];
		for (int i = 1; i < size; i++) {
			subSum[i] = stones[i] + subSum[i - 1];
			//System.out.print(subSum[i] +", ");
		}

//		 this time need to start from count = 1
		for (int count = 1; count < size; count++) {
			for (int i = 0; i + count < size; i++) {
				int globalMin = Integer.MAX_VALUE;
				for (int j = i; j < i + count; j++) {
						globalMin = Math.min(globalMin, records[i][j]
							+ records[j + 1][i + count] + subSum[i + count] - subSum[i] + stones[i]);
					
				}
				records[i][i + count] = globalMin;
				System.out.println("result[" + i + "][" + (i+count)+ "] is: " + globalMin);
			}
		}
		
/*		for (int i = 0; i < size; i++) {
			for (int j = i; j >= 0; j--) {
				if (i == j) {
					records[j][i] = 0;
					subSum[j][i] = stones[i];
				} else {
					subSum[j][i] = subSum[j][i - 1] + stones[i];
					records[j][i] = Integer.MAX_VALUE;
					for (int k = j; k < i; k++ ) {
						records[j][i] = Math.min(records[j][i], records[j][k] + records[k + 1][i] + subSum[j][i]);
					}
				}
			}
		}*/

		return records[0][size - 1];
	}

}
