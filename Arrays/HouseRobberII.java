213. House Robber II - https://leetcode.com/problems/house-robber-ii/description/ - MEDIMUM

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (1 == len) {
            return nums[0];
        }

        return Math.max(max(nums, 0, len-2), max(nums, 1, len-1));
    }

    private int max(int[] nums, int low, int end) {
        int max = 0;
        int curMax = 0;
        for (int i = low; i <= end; i++) {
            int temp = max;
            max = Math.max(max, curMax + nums[i]);
            // max = without current house, with current house
            curMax = temp;
        }
        return max;
    }
}
