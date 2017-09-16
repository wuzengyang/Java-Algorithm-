package DP;

import java.util.ArrayList;
import java.util.List;


/**
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color red; costs[1][2] is the cost of painting house 1 with color green, and
 * so on... Find the minimum cost to paint all houses.
 * 
 * @author Tianpeng
 *
 */

public class PaintHouse {
	
	

    public int[] minCost(int[][] costs) 
    if (costs == null | costs.length == 0 || costs[0].length == 0) {
        return 0;
    }

    if (costs.length == 1) {
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
    
    int n = 1;
    if ( n == 0) {
    	return new int[] {};
    }
    
    List<String> test = new ArrayList<>();
    
    
    int[] index1 = sortArray(costs, 0);
    int[] index2 = sortArray(costs, 1); 
    int pre1 = costs[0][index1[0]];
    int pre2 = 0;
    int preIndex1 = 0;
    int preIndex2 = 0;
    int finalCost = 0;
    if (costs.length == 2) {

        if (index1[0] != index2[0]) {	
        	pre2 = costs[0][index1[0]] + costs[0][index2[0]];
        	preIndex1 = index1[0];
        	preIndex2 = index2[0];
        } else {
        	if (costs[0][index1[0]] + costs[0][index2[1]] > costs[0][index1[1]] + costs[0][index2[0]]) {
        		pre2 = costs[0][index1[1]] + costs[0][index2[0]];
        		preIndex1 = index1[1];
        		preIndex2 = index2[0];
        	} else {
        		pre2 = costs[0][index1[0]] + costs[0][index2[1]];
        		preIndex1 = index1[0];
        		preIndex2 = index2[1];
        	}
        }
    }
    
    for (int i = 2; i < costs.length; i++) {
    	int[] index3 = sortArray(costs, i);
    	if (index3[0] != preIndex2) {
    		finalCost = pre2 + costs[i][index3[0]];
    	} else {
    		
    	}
    }
    
}

/**
 * This Method sorts elements and return the indexes: descending  
 * In this case, the length of all row are 3
 * @param costs
 * @param rwo
 * @return
 */
public int[] sortArray(int[][] costs, int row) {
  int max = 0;
  int min = 0;
  int maxValue = Integer.MIN_VALUE;
  int minValue = Integer.MAX_VALUE;
  for (int i = 0; i < 3; i ++) {
	  if (maxValue < costs[row][i]) {
		  maxValue = costs[row][i];
		  max = i;
	  }
	  if (minValue > costs[row][i]) {
		  minValue = costs[row][i];
		  min = i;
	  }
  }
  return new int[] {min, 3 - max - min, max};
}

}
