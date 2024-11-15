26. Remove Duplicates from Sorted Array - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/ - EASY

class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;

        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }
}
