package laiOfferTest;

public class CuttingWoodI {
	
	public static void main(String[] args) {
		int[] test = {1, 3, 7, 9, 13};
		int length = 16;
		System.out.println(minCost(test, length));
	}

	public static int minCost(int[] cuts, int length) {
		// Write your solution here.
		if (length <= 1) {
			return 0;
		}

		int size = cuts.length;
		int[] cuts2 = new int[size + 2];
		for (int i = 1; i < size + 1; i++) {
			cuts2[i] = cuts[i - 1];
		}
		cuts2[size + 1] = length;
		int size2 = cuts2.length;
		
		/***********************************/
		System.out.println("The new array is: ");
		for (int a : cuts2) {
			System.out.print(a + ", ");
		}
		System.out.println();
		/***************************************/

		int[][] records = new int[size2][size2];
		// step one: consider cuts with only one step
		// all elements in records are 0 now, so no actions needed is this step

		// Step tw0, cut with index distance two
		for (int count = 2; count < size2; count++) {
			for (int i = 0; i + count < size2; i++) {
				// check possible combination?]
				int globalMin = Integer.MAX_VALUE;
				for (int j = i + 1; j < i + count; j++) {
					globalMin = Math.min(globalMin, cuts2[i + count] - cuts2[i]
							+ records[i][j] + records[j][i + count]);
				}
				records[i][i + count] = globalMin;
			}
		}

		System.out.println("The final matrix is: ");
		for (int i = 0; i < size2; i++) {
			for (int j = 0; j < size2; j++) {
				System.out.print(records[i][j] + ", ");
			}
			System.out.println();
		}
		
		
		System.out.println("The minCost is: ");
		return records[0][size2 - 1];
	}
}
