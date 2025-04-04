152. Maximum Product Subarray - https://leetcode.com/problems/maximum-product-subarray/description/
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

I: T(O(n)), S(O(1)):
We are basically using Kadane's algo and instead of just curMax, will use curMax and curMin
to handle the case when the product is negative.

class Solution {
    public int maxProduct(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        }
        
        int ans = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(temp * nums[i], curMin * nums[i]));
            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}

II: T(O(n^2)), S(O(1)) - Brute Force
 class Solution {
    public int maxProduct(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        }

        int max = nums[0]; // Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
          int prod = 1;
          for (int j = i; j < nums.length; j++) {
               prod *= nums[j];
               max = Math.max(max, prod);
          }
        }

        return max;
    }
}
 
