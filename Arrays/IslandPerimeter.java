463. Island Perimeter - https://leetcode.com/problems/island-perimeter/description/ - EASY

class Solution {
    public int islandPerimeter(int[][] grid) {
        int perm = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (1 == grid[i][j]) {
                    perm += 4;
                    if (i > 0 && 1 == grid[i-1][j]) { // Up or top sharing land
                        perm -= 2;
                    }

                    if (j > 0 && 1 == grid[i][j-1]) { // left sharing land
                        perm -= 2;
                    }
                }
            }
        }
        return perm;
    }
}
