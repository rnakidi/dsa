322. Coin Change - https://leetcode.com/problems/coin-change/description/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

T(O(m*n)), S(O(n)):
Amount to make:
Coin choices:
remaining amount:

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (1 > amount) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && Integer.MAX_VALUE != dp[i - coin]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]); // curent min value, 1(this coin) + the prevoius coin count
                }
            }
        }

        return Integer.MAX_VALUE == dp[amount] ? -1 : dp[amount];
    } 
}
