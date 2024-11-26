210. Course Schedule II - https://leetcode.com/problems/course-schedule-ii/description/ - MEDIUM

class Solution {
    List<Integer> orderList;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        orderList = new ArrayList<>();
        if (canFinish(numCourses, prerequisites)) {
            return orderList.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[]{};
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] preReqs = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preReqs[i] = new ArrayList<>();
        }
        
        for (int[] pre : prerequisites) {
            preReqs[pre[0]].add(pre[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preReqs, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<Integer>[] preReqs, int[] visited) {
        if (1 == visited[node]) {
            return false;
        }

        if (2 == visited[node]) {
            return true;
        }

        visited[node] = 1;
        for (int n : preReqs[node]) {
            if (!dfs(n, preReqs, visited)) {
                return false;
            }
        }

        visited[node] = 2;
        orderList.add(node);
        return true;
    }
}
