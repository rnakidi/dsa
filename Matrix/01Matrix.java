542. 01 Matrix - https://leetcode.com/problems/01-matrix/description/ - MEDIUM
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int dirs[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int dist = 0;
        while(!q.isEmpty()) {
            dist++;
            int size = q.size();
            while(size-- > 0) {
                int[] cell = q.poll();
                for (int[] dir : dirs) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r < 0 || c < 0 || r == mat.length || c == mat[0].length || mat[r][c] != -1) {
                        continue;         
                    }
                    mat[r][c]=dist;
                    q.add(new int[] {r, c});
                }

            }
        }

        return mat;
        
    }
}
