75. Sort Colors - https://leetcode.com/problems/sort-colors/description/?envType=problem-list-v2&envId=array
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Approach - 1: Frequency count
class Solution {
    public void sortColors(int[] nums) {
        if (1 == nums.length) {
    		  return;
    	  }
    	
    	// Frequency count
    	int[] table = new int[3];
    	for (int num : nums) {
    		table[num]++;
    	}
    	
    	int idx = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (table[idx] == 0) {
    			idx++;
    		}
    		nums[i] = idx;
    		table[idx]--;
    	}
    }
}

Approach - 2: 3 pointers
class Solution {
    public void sortColors(int[] nums) {
    	if (1 == nums.length) {
    		return;
    	}
    	
    	// Three pointers
    	int red = 0;
    	int white = 0;
    	int blue = nums.length - 1;
    	
    	while (white <= blue) {
    		if (0 == nums[white]) { // Red
    			swap(nums, white, red);
    			white++;
    			red++;
    		} else if (1 == nums[white]) {
    			white++;
    		} else {
    			swap(nums, white, blue);
    			white++;
    			blue--;
            }
        }
    }
}
