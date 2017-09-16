package DP;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 * 
 * @author Tianpeng
 *
 */
public class CoinChange {
	
	public static void main(String[] args) {
		int[] test = {1};
		int amount = 0;
		System.out.println(coinChange(test, amount));
	
	}

	
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        
        int[] result = new int[amount + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
//        for (int i = 0; i <= amount; i++ ) {
//            if (i > 0 && result[i] == Integer.MAX_VALUE) {
//                continue;
//            }
//            for (int j = 0; j < coins.length; j++) {
//            	long temp = i + coins[j];
//                if (temp <= amount) {
//                   result[i + coins[j]] = Math.min(result[i + coins[j]], result[i] + 1);  
//                }
//            }
//        }
        
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && result[i - coins[j]] != Integer.MAX_VALUE) {
                    result[i] = Math.min(result[i], result[i - coins[j]] + 1);
                }
            }
        }
        
        return result[amount] == Integer.MAX_VALUE? -1 : result[amount];
    }
}
