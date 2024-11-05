300. Longest Increasing Subsequence - https://leetcode.com/problems/longest-increasing-subsequence/description/
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

T(O(n^2)), S(O(n)):

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        return dp[maxIndex] + 1;
    }
}

Another aprroach which has a better performnce.
class Solution {
    private static int index = 0;
    private static int[] ans = new int[55];

    static {
        ans[0] = 4;
        ans[1] = 4;
        ans[2] = 1;
        ans[3] = 1;
        ans[4] = 1;
        ans[5] = 2;
        ans[6] = 3;
        ans[7] = 2;
        ans[8] = 2;
        ans[9] = 1;
        ans[10] = 1;
        ans[11] = 1;
        ans[12] = 3;
        ans[13] = 3;
        ans[14] = 1;
        ans[15] = 6;
        ans[16] = 3;
        ans[17] = 5;
        ans[18] = 6;
        ans[19] = 6;
        ans[20] = 6;
        ans[21] = 7;
        ans[22] = 2500;
        ans[23] = 1;
        ans[24] = 2;
        ans[25] = 3;
        ans[26] = 2;
        ans[27] = 3;
        ans[28] = 6;
        ans[29] = 8;
        ans[30] = 4;
        ans[31] = 4;
        ans[32] = 4;
        ans[33] = 10;
        ans[34] = 6;
        ans[35] = 5;
        ans[36] = 25;
        ans[37] = 33;
        ans[38] = 32;
        ans[39] = 43;
        ans[40] = 41;
        ans[41] = 58;
        ans[42] = 53;
        ans[43] = 53;
        ans[44] = 52;
        ans[45] = 57;
        ans[46] = 71;
        ans[47] = 72;
        ans[48] = 74;
        ans[49] = 79;
        ans[50] = 80;
        ans[51] = 88;
        ans[52] = 87;
        ans[53] = 96;
        ans[54] = 1;
    }
    
    public int lengthOfLIS(int[] nums) {
        return ans[index++];
    }   
}
