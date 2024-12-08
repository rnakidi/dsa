169. Majority Element - https://leetcode.com/problems/majority-element/description/ - EASY

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (0 == count) {
                res = num;
            }

            if (num == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}

- If sorted:
Arrays.sort(nums);
int len  = nums.length/2;
return nums[len];
