62. Unique Paths
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: m = 3, n = 7
Output: 28
  
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:

1 <= m, n <= 100

Solution-Recursion without Memorization)(T:(2^n), S:O(n))
class Solution {
    public int uniquePaths(int m, int n) {
        return util(0, 0, m, n);        
    }

    public int util(int r, int c, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0;
        }

        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        return util(r + 1, c, m, n) + util(r, c + 1, m, n);
    }
}

Solution-Recurion with Memorization)(T:(n^2), S:O(n))
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        return util(0, 0, m, n, paths);        
    }

    public int util(int r, int c, int m, int n, int[][] paths) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0;
        }

        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        if (paths[r][c] != 0) {
            return  paths[r][c];
        }

        return paths[r][c] = util(r + 1, c, m, n, paths) + util(r, c + 1, m, n, paths);
    }
}
