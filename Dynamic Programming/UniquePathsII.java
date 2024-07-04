63. Unique Paths II
Description
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.

Solution(Recursion + Without Memorization)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return util(obstacleGrid, 0, 0);
    }

    private int util(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) {
            return 0;
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return 1;
        }

        return util(grid, r+1, c) + util(grid, r, c+1);
    }
}

Solution(Recursion + With Memorization)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return util(obstacleGrid, 0, 0, dp);
    }

    private int util(int[][] grid, int r, int c, int[][] dp) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) {
            return 0;
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return 1;
        }

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        return dp[r][c] = util(grid, r+1, c, dp) + util(grid, r, c+1, dp);
    }
}
