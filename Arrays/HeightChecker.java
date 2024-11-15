1051. Height Checker - https://leetcode.com/problems/height-checker/description/ - EASY

class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            temp[i] = heights[i];
        }
        
        int count = 0;
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != heights[i]) {
                count++;
            }
        } 
        return count;
    }
}
