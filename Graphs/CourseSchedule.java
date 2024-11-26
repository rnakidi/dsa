207. Course Schedule - https://leetcode.com/problems/course-schedule/description/ - MEDIUM(https://www.youtube.com/watch?v=EgI5nU9etnU&t=820s)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] preReqs = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preReqs[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            preReqs[pre[0]].add(pre[1]);
        }

        int[] visited = new int[numCourses]; // For loop detection and etc
        for (int i = 0; i < numCourses; i++) { // For un connected nodes in graph(For ex: [1,2], [3,4])
            if (!dfs(i, preReqs, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<Integer>[] preReqs, int[] visited) {
        if (visited[node] == 1) {
            return false;
        }

        if (visited[node] == 2) { // Leaf node or empty node
            return true;
        }

        visited[node] = 1;
        for (int n : preReqs[node]) {
            if (!dfs(n, preReqs, visited)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
}
