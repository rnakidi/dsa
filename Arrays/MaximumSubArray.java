53. Maximum Subarray - https://leetcode.com/problems/maximum-subarray/description/
G
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

T(O(n)), S(O(1)):

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
          maxSoFar = Math.max(maxSoFar + arr[i], arr[i]);
          res = Math.max(res, maxSoFar);
        }
      return res;
    }
}

An another approach which has better performance than the above one.
 class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > maxSum) {
                maxSum = curSum;
            }

            if (curSum < 0) {
                curSum = 0; // reset
            }
        }
        return maxSum;
    }
}
