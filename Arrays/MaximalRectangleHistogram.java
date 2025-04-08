85. Maximal Rectangle - https://leetcode.com/problems/maximal-rectangle/description/?envType=problem-list-v2&envId=array
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.

T: O(m*n), S: O(m) - m=rows, n=cols
class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Prepare histogram with heights
    	int maxArea = Integer.MIN_VALUE;
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	int[] heights = new int[cols + 1]; // +1 to cover right side lower height
    	for (char[] row : matrix) {
    		for (int j = 0; j < cols; j++) {
    			heights[j] = '1' == row[j] ? heights[j] + 1 : 0;
    		}
    		// Calculate area for each row histogram - same as https://leetcode.com/problems/largest-rectangle-in-histogram/description/?envType=problem-list-v2&envId=array
    		maxArea = Math.max(maxArea, largestRectangleArea(heights));
    	}
    	
    	return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
    	int maxArea = Integer.MIN_VALUE;
    	Stack<Integer> st = new Stack<>();
    	for (int i = 0; i < heights.length; i++) {
    		while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
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
