417. Pacific Atlantic Water Flow - https://leetcode.com/problems/pacific-atlantic-water-flow/description/ - MEDIUM

class Solution {
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        // Start DFS from oceans sides(Top, bottom, left & right)
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pac, heights[0][c]);  // Pacific(top)
            dfs(heights, rows - 1, c, atl, heights[rows - 1][c]);  // Atlantic(bottom)
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pac, heights[r][0]); // left
            dfs(heights, r, cols - 1, atl, heights[r][cols-1]); // right
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    List<Integer> subRes = List.of(r, c);
                    res.add(subRes);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;
        dfs(heights, row - 1, col, visited, heights[row][col]); // top or up
        dfs(heights, row + 1, col, visited, heights[row][col]); // bottom or down
        dfs(heights, row, col - 1, visited, heights[row][col]); // left
        dfs(heights, row, col + 1, visited, heights[row][col]); // right
    }
}
