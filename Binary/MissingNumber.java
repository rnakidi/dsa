268. Missing Number - https://leetcode.com/problems/missing-number/description/
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

 Approach-I: Using sum of elements(T(O(n)), S(O(1))
 class Solution {

    public int missingNum(int[] arr) {
    	int ans = arr.length;
        for (int i = 0; i < arr.length; i++) {
       			ans += i - arr[i];
        }
        return ans;
    }
}

Approach-II: Using sum of elements(T(O(n)), S(O(1))
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (len * (len+1))/2;
         for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}

Approach-III: Using 2 XORs(T(O(n)), S(O(1))
 class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            ans = ans ^ i;
        }

        for (int num : nums) {
            ans = ans ^ num;
        }

        return ans;
    }
}
 
Approach-IV: Using integer array with on/off flagT(O(n)), S(O(n))
class Solution {
    public int missingNumber(int[] nums) {
        int[] count = new int[nums.length + 1];
         for (int num : nums) {
            count[num] = 1;
        }
        
        for (int i = 0; i < count.length; i++) {
            if (0 == count[i]) {
                return i;
            }
        }

        return -1;
    }
}
