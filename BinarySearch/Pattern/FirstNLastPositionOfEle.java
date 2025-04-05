34. Find First and Last Position of Element in Sorted Array - 
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

  class Solution {
    public int[] searchRange(int[] nums, int target) {
    	if (null == nums || 0 == nums.length) {
    		return new int[] {-1, -1};
    	}
    	
        int firstPos = helper(nums, target);
        if (firstPos == -1) {
        	return new int[] {firstPos, firstPos};
        } else if (firstPos == nums.length - 1 || nums[firstPos - 1] == target)) {
            return new int[] {firstPos - 1, firstPos};
        } else {
            return new int[] {firstPos, firstPos + 1};
        }
    }

    private int helper(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
