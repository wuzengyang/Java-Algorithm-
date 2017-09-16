package DP;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again). After you sell your stock, you cannot
 * buy stock on next day. (ie, cooldown 1 day) Example:
 * 
 * prices = [1, 2, 3, 0, 2] maxProfit = 3 transactions = [buy, sell, cooldown,
 * buy, sell]
 * 
 * @author Tianpeng
 *
 */

public class BestTimetoBuyandSellStockII {
	
	public static void main(String[] args) {
//		int[] test = {6,1,3,2,4,7};
		int[] test = {1, 2, 9, 0 , 1, 3, 9, 1, 1, 2, 3, 5, 4, 1};
		System.out.println(maxProfit(test));
		System.out.println(maxProfit2(test));
	}
	
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        // step one: find rangeMin matrix
        int N = prices.length;
/*        int[][] min = new int[N][N];
        for (int count = 0; count < N; count++) {
            for (int i = 0; i + count< N; i++) {
                if (count == 0) {
                    min[i][i + count] = prices[i];
                } else {
                    min[i][i + count] = Math.min(min[i][i + count - 1], prices[count]);
                }
            }
        }*/
        
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = j - 2 >= 0? result[j - 2] : 0;
                int temp1 = j - 1 >= 0? result[j - 1] : 0;
                result[i] = Math.max(prices[i] - prices[j] + temp, Math.max(result[i], temp1));
            }
        }
        
        for (int temp : result) {
        	System.out.print(temp + ", ");
        }
        System.out.println();
        
        return result[N - 1];
        
    }
    
    public static int maxProfit2(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

}
