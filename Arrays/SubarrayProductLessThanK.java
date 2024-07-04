713. Subarray Product Less Than K
Description
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
  
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

Solution(T:O(n), S:O(1))
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {                
        int n = nums.length;
        int right = 0;
        int left = 0;
        int ans = 0;
        int prod = 1;

        while (right < n) {
            prod *= nums[right];
            while (prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }
            ans += (right - left + 1);
            right++;
        }

        return ans;
    }
}

Solution(DRAFT - INPROGRESS)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count++;
            }
        }

        for (int n = 2; n <= nums.length; n++) {
            count += util(nums, n, k);
        }

        return count;
    }

    private int util(int[] nums, int k, int target) {
        int count = 0;
        long prev = 1;
        for (int i = 0; i < k; i++) {
            prev *= nums[i];
        }

        if (prev < target) {
            count++;
        }

        for (int i = 1; i <= nums.length - k; i++) {
            long cur = (prev/nums[i-1]) * nums[i-1+k];
            if (cur < target) {
                count++;
            }
            prev = cur;
        }
        
        return count;
    }
}
