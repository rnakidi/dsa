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

  
