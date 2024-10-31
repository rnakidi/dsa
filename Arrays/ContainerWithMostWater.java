11. Container With Most Water - https://leetcode.com/problems/container-with-most-water/
ou are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104

T(O(n)), S(O(1)), ~5ms: area = width * height, heights are given and need to find a width.
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]); // area = width * height, taking min to avoid overflowed water
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else if(height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return maxArea;  
    }
}

The following code is slighly modified version of above code and it'll have better perfomrmance(~2ms)
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int curHeight = Math.min(height[left], height[right]);
            int area = (right - left) * curHeight; // area = width * height, taking min to avoid overflowed water
            maxArea = Math.max(maxArea, area);

            /*if (height[left] < height[right]) {
                left++;
            } else if(height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }*/

            while (left < right && height[left] <= curHeight) {
                left++;
            }

            while (left < right && height[right] <= curHeight) {
                right--;
            }
        }

        return maxArea;  
    }
}
