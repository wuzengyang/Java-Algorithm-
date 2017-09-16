package DP;

public class PaintHouseII {
	
	public static void main(String[] args) {
//		int[][] test = { { 10, 15, 12, 14, 18, 5 }, 
//						 { 5, 12, 18, 13, 15, 8 },
//						 { 4, 7, 4, 2, 10, 18 }, 
//						 { 20, 9, 9, 19, 20, 5 },
//						 { 10, 15, 10, 15, 16, 20 }, 
//						 { 9, 6, 11, 10, 12, 11 },
//						 { 7, 10, 6, 12, 20, 8 }, 
//						 { 3, 4, 4, 18, 10, 2 } };
		int[][] test =  {{8,16,12,18,9},
		                 {19,18,8,2,8},
		                 {8,5,5,13,4},
		                 {15,9,3,19,2},
		                 {8,7,1,8,17},
		                 {8,2,8,15,5},
		                 {8,17,1,15,3},
		                 {8,8,5,5,16},
		                 {2,2,18,2,9}};
		System.out.println(minCostII(test));
	}

	
    public static int minCostII(int[][] costs) {
        
        // lets try time O(nk) space O(k)
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int[] curRow = new int[costs[0].length];
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        int curIndex = 0;

        for (int i = 0; i < costs.length; i++) {
            int preMin = min;
            int preSecMin = secMin;
            int preIndex = curIndex;
            min = Integer.MAX_VALUE;
            secMin = Integer.MAX_VALUE;
            for (int j = 0; j  < costs[0].length; j++) {
            	if (i == 0) {
            		curRow[j] = costs[0][j];
            	} else {
            		curRow[j] = preIndex == j? costs[i][j] + preSecMin : costs[i][j] + preMin;
            	}
                
                if (min >= curRow[j]) { // in case we have duplicate elements 
                	secMin = min;
                    min = curRow[j];
                    curIndex = j;
                }
                if (curRow[j] > min && secMin > curRow[j]) {
                	secMin = curRow[j];
                }
            }
        }
        
        return min;

    }

}
