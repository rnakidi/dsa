# 704. Binary Search - https://leetcode.com/problems/binary-search/description/
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

## Approach1: Iterative
 
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                low = mid - 1;
            }
        }

        return -1;
    }
}

## Approach1: Recursive
class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length, target);
    }

    private helper(int[] nums, int low, int high, int target) {
      if (low <= high) {
        int mid = low + (high - low)/2;
        if (target == nums[mid]) {
          return mid;
       }

        if (target < nums[mid]) {
          return helper(nums, low, mid - 1, target);
        } else {
         return helper(nums, mid + 1, hih, target)
          }       
     }
     return -1;
   }
}
