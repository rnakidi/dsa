286. Walls and Gates
Description:
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

Solution(BFS - T:O(m*n), S:O(m+n))
public class WallsAndGates {
	public static void wallsAndGates(int[][] grid) {
		Queue<int[]> que = new LinkedList<>(); // We can also use Deque
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++) {
				if (grid[i][j] == 0) {
					que.add(new int[] {i, j});
				}
			}
		}
		
		int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
		int dist = 0;
		while (!que.isEmpty()) {
			dist++;
			int size = que.size();
			while (size-- > 0) {
				int[] cell = que.poll();
				for (int[] dr : dirs) {
					int r = cell[0] + dr[0];
					int c = cell[1] + dr[1];
					
					if (r > -1 && r < rows && c > -1 && c < cols && grid[r][c] == Integer.MAX_VALUE) {
						grid[r][c] = dist;
						que.offer(new int[] {r, c});
					}
				}
			}
		}
	}
