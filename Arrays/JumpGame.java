55. Jump Game - https://leetcode.com/problems/jump-game/description/ - MEDIUM

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxReach = 0;

        for (int i = 0; i < len; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
