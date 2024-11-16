746. Min Cost Climbing Stairs - https://leetcode.com/problems/min-cost-climbing-stairs/description/ - EASY

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] mem = new int[n];
        Arrays.fill(mem, -1);
        return Math.min(minCost(cost, n-1, mem), minCost(cost, n-2, mem));
    }

    private int minCost(int[] cost , int n, int[] mem) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return cost[n];
        }

        if (mem[n] != -1) {
            return mem[n];
        }

        mem[n] = cost[n] + Math.min(minCost(cost, n-1, mem), minCost(cost, n-2, mem));
        return mem[n];
    }
}
