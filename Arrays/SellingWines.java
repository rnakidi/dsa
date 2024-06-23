Selling Wines
Description
Given n wines in a row, with integers denoting the cost of each wine respectively. Each year you can sell the first 
or the last wine in the row. Let the initial profits from the wines be P1, P2, P3…Pn. In the Yth year, the profit from 
the ith wine will be Y*P[i]. The goal is to calculate the maximum profit that can be earned by selling all the wines.

Input: Price of wines: 2 4 6 2 5
Output: beg end end beg beg 
  64

1. Greedy/Brute Force Approach:
price = 1*2 = 2, remaining wines = [ 4, 6, 2, 5 ], Profit = 2
price = 2*4 = 8, remaining wines = [ 6, 2, 5 ], Profit = 10
price = 3*5 = 15, remaining wines = [ 6, 2 ], Profit = 25
price = 4*2 = 8, remaining wines = [ 6 ], Profit = 33
price = 5*6 = 30, remaining wines = [ ], Profit = 63

This is wrong as aanswer/max profit is - 64. 
The corret way is -
price = 1*2 = 2, remaining wines = [ 4, 6, 2, 5 ], Profit = 2
price = 2*5 = 10, remaining wines = [ 4, 6, 2 ], Profit = 12
price = 3*2 = 6, remaining wines = [ 4, 6], Profit = 18
price = 4*4 = 16, remaining wines = [ 6 ], Profit = 34
price = 5*6 = 30, remaining wines = [ ], Profit = 64

This gives an idea to us that, this is a good problem for DP(Dynamic Programming), i.e. "Recursion + Memorization + Guessing".
Let's keep the step "Memorization" aside for now and come up with an algorith/code which involves both "Recursion" + "Guessing".
"Guessing" because we need to guess the profit from both the ends - "left" and "right" and chose the one which has maximum profit value.

  2. Recursion + Guessing (T:O(2^n), S:O(n))
  class Solution {
	
	  public int util(int[] prices, int begin, int end, int year) {
		  if (begin > end) {
			    return 0;
		  }
		
		  if (begin == end) {
			    return year * prices[begin];
		  }
		
		  int left = year*prices[begin] + util(prices, begin + 1, end, year + 1);
		  int right = year*prices[end] + util(prices, begin, end - 1, year + 1);
      
		  return Math.max(left,  right);
	  }
	
	  public int maxProfit(int[] prices, int n) {
		  return util(prices, 0, n - 1, 1);
	  }
}

3. Memorization (T:O(n^2), S:O(n^2))
  #2 will be taking execution time in exponentional- O(2^n). So, apply memorization to reduce the time complexity to polynomial -  O(n^2).
    class Solution {
	
	  public int util(int[] prices, int begin, int end, int year, int[][] dp) {
		  if (begin > end) {
			return 0;
		  }
		
		  if (begin == end) {
			return year * prices[begin];
		  }

      		  if (dp[begin][end] != 0) {
			return dp[begin][end];
      		  }		
		
		  int left = year*prices[begin] + util(prices, begin + 1, end, year + 1);
		  int right = year*prices[end] + util(prices, begin, end - 1, year + 1);
      
		  return dp[begin][end] = Math.max(left,  right);
	  }
	
	  public int maxProfit(int[] prices, int n) {
      		  int[][] dp = new int[n][n];
		  return util(prices, 0, n - 1, 1, dp);
	  }
}

4. Iteration approach with Memorization - (T:O(n^2), S:O(n^2))
    class Solution {
	public int maxProfitIteration(int[] prices, int n) {
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = n * prices[i];
		}
		
		for (int begin = n-2; begin >= 0; begin--) {
			for (int end = begin + 1; end < n; end++) {
        			int year = n - (end - begin); // n + 1 - (end - begin + 1)				
				int left = year*prices[begin] + dp[begin+1][end];
				int right = year*prices[end] + dp[begin][end-1];
				dp[begin][end] = Math.max(left,  right);
			}
		}
		
		return dp[0][n-1];
	}
}  
  
