84. Largest Rectangle in Histogram - https://leetcode.com/problems/largest-rectangle-in-histogram/description/?envType=problem-list-v2&envId=array
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:

Input: heights = [2,4]
Output: 4

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

T: O(N) & S: O(N)
class Solution {
    public int largestRectangleArea(int[] heights) {
        // area = width * height
    	int maxArea = Integer.MIN_VALUE;
    	Stack<Integer> st = new Stack<>();
    	int len = heights.length;
    	for (int i = 0; i <= len; i++) {
    		int curHeight = i == len ? 0 : heights[i];
    		while (!st.isEmpty() && curHeight < heights[st.peek()]) {
    			int top = st.pop();
    			int width = st.isEmpty() ? i : i - st.peek() - 1;
    			int area = width * heights[top];
    			maxArea = Math.max(maxArea, area);
    		}
    		st.push(i);
    	}
    	
    	return maxArea;
    }
}
