package DP;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author Tianpeng
 *
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        //  similar to paint house questions
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int N = triangle.size(); // equals to the size of last row
/*        int[][] result = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            List<Integer> temp = triangle.get(i - 1);
            for (int j = 1; j <= temp.size(); j++) {
                if (j == 1) {
                    result[i][j] = temp.get(j - 1) + result[i - 1][j];
                } else if (j == temp.size()) {
                    result[i][j] = temp.get(j - 1) + result[i - 1][j - 1];
                } else {
                   result[i][j] = temp.get(j - 1) + Math.min(result[i - 1][j - 1], result[i - 1][j]); 
                }
            }
        }*/
        
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
        	int[] preResult = result;
            List<Integer> temp = triangle.get(i - 1);
            for (int j = 1; j <= temp.size(); j++) {
                if (j == 1) {
                    result[j] = temp.get(j - 1) + preResult[j];
                } else if (j == temp.size()) {
                    result[j] = temp.get(j - 1) + preResult[j - 1];
                } else {
                   result[i] = temp.get(j - 1) + Math.min(preResult[j - 1], preResult[j]); 
                }
            }
        }
        
        int globalMin = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            globalMin = Math.min(globalMin, result[i]);
        }
        return globalMin;
    }
}
