1277. Count Square Submatrices with All Ones - https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        // Fill dp with firts row - base case
        for (int c = 0; c < cols; c++) {
            dp[0][c] = matrix[0][c];
        }

        // Fill dp with first column - base case
        for (int r = 0; r < rows; r++) {
            dp[r][0] = matrix[r][0];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (1 == matrix[r][c]) {
                    dp[r][c] = 1 + Math.min(dp[r-1][c], Math.min(dp[r-1][c-1], dp[r][c-1])); // Recurrence relation
                }
            }
        }
        
        int count = 0;
        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                count += dp[r][c];
            }
        }

        return count;
    }
}
