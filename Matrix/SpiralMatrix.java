54. Spiral Matrix
  
Description:
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
  
Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

Solution(T:O(m*n), S:O(m*n))

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (null == matrix) {
            return result;
        }

        int r = matrix.length;
        int c = matrix[0].length;
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int X = 0;
        int Y = 0;
        int di = 0;
        boolean[][] seen = new boolean[r][c];

        for (int i = 0; i < r*c; i++) {
            result.add(matrix[X][Y]);
            seen[X][Y] = true;
            int cr = X + dr[di];
            int cc = Y + dc[di];

            if (cr > -1 && cr < r && cc > -1 && cc < c && !seen[cr][cc]) {
                X = cr;
                Y = cc;
            } else {
                di = (di + 1)%4;
                X = X + dr[di];
                Y = Y + dc[di];
            }

        }
        return result;
    }
}
