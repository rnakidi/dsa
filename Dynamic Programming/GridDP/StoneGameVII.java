1690. Stone Game VII - https://leetcode.com/problems/stone-game-vii/description/

class Solution {
    int[] prefixSum;
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        // Use Top Down DP + Memorization
        prefixSum = new int[len + 1];

        // Prefix sum for O(1) lookup
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i-1] + stones[i-1];
        }

        int[][] mem = new int[len][len];
        for (int[] m : mem) {
            Arrays.fill(m, -1);
        }
        return dp(0, len - 1, mem);
    }

    private int dp(int begin, int end,int[][] mem) {
        if (begin > end) { // base case
            return 0;
        }
        
        if (-1 != mem[begin][end]) {
            return mem[begin][end];
        }
        
        // Recurrence relation
        int leftSum = prefixSum[end + 1] - prefixSum[begin + 1];
        int choice1 = leftSum - dp(begin + 1, end, mem);
        int rightSum = prefixSum[end] - prefixSum[begin];
        int choice2 = rightSum - dp(begin, end - 1, mem);
        
        return mem[begin][end] = Math.max(choice1, choice2); // Memorization
    }
}
