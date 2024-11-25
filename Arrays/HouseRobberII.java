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

Approach - II(Same as HouseRobberyI:

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (1 == len) {
            return nums[0];
        }

        return Math.max(max(nums, 0, len-2), max(nums, 1, len-1));
    }

    private int max(int[] nums, int low, int end) {
        int[] temp = new int[end - low + 1];
        int j = 0;
        for (int i = low; i <= end; i++) {
            temp[j++] = nums[i];
        }

        int n = temp.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = temp[0];
        for (int i = 1; i < n; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + temp[i]);           
        }

        return dp[n];
    }
}
