4. Median of Two Sorted Arrays - https://leetcode.com/problems/median-of-two-sorted-arrays/description/ - HARD
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

T(O(m + n)), S(O(m+n)):
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = nums1.length;
        int right = nums2.length;
        int[] merged = new int[left + right];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < left) {
           merged[k++]  = nums1[i++];
        }

        while (j < right) {
            merged[k++]  = nums2[j++];
        }

        int len = merged.length;
        int rem = len % 2;
        if (0 == rem) {
            return (double) (merged[len/2 - 1] + merged[len/2])/2;            
        } else {
            return (double) merged[len/2];
        }
    }
}
