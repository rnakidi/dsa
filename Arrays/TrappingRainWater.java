42. Trapping Rain Water
Description
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9 

Constraints:

n == height.length
1 <= n <= 2 * 104

Solution(T:O(n^2), S:O(1))
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            
            int left = height[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            int right = height[i];
            for (int j = i + 1; j < len; j++) {
                right = Math.max(right, height[j]);
            }

            ans += Math.min(left, right) - height[i];
        }
    
        return ans;        
    }
}

Solution(T:O(n), S:O(n))
class Solution {
    public int trap(int[] height) {
        int water = 0;
        int len = height.length;

        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }

        int[] right = new int[len];
        right[len-1] = height[len-1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }

        for (int i = 0; i < len; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;        
    }
}
