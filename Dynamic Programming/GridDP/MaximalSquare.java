221. Maximal Square - https://leetcode.com/problems/maximal-square/ - Medimum
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1


class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSideLength = 0;
        int[][] dp = new int[rows][cols];
        // Fill the dp with first row
        for (int c = 0; c < cols; c++) {
            if ('1' == matrix[0][c]) {
                dp[0][c] = 1;
                maxSideLength = 1;
            }
        }
        
        // Fill the dp with first column
        for (int r = 0; r < rows; r++) {
            if ('1' == matrix[r][0]) {
                dp[r][0] = 1;
                 maxSideLength = Math.max(maxSideLength, 1);
            }
        }


        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if ('1' == matrix[r][c]) {
                    dp[r][c] = 1 + Math.min(dp[r-1][c], Math.min(dp[r-1][c-1], dp[r][c-1]));
                    maxSideLength = Math.max(maxSideLength, dp[r][c]);

                }
            }
        }

        return maxSideLength * maxSideLength; // Area of the maximal square
    }
}

Time & Space complextity: T(O(r*c)) nd S(O(r*c))
