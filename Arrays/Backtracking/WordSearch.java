79. Word Search - https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=array

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters. 

Follow up: Could you use search pruning to make your solution faster with a larger board?

T: O(r*c*4^l) - r = rows, c= cols, 4 = backtracks, l = length of the word
class Solution {
    public boolean exist(char[][] board, String word) {
    	int rows = board.length;
    	int cols = board[0].length;
    	
    	boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (word.charAt(0) == board[i][j]) {
        			if (exist(board, i, j, word, 0, visited)) { // backtrack
        				return true;
        			}
        		}
        	}
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
    	if (index == word.length()) { // Base case - goal reached
    		return true;
    	}
    	
    	if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
    		|| visited[row][col] || word.charAt(index) != board[row][col]) {
    		return false;
    	}
    	visited[row][col] = true; // Make a choice
    	if (exist(board, row - 1, col, word, index + 1, visited) // Up
    		|| exist(board, row + 1, col, word, index + 1, visited) // Down
    		|| exist(board, row, col - 1, word, index + 1, visited) // Left
    		|| exist(board, row, col + 1, word, index + 1, visited))  { // Right
    		return true;
    	}
    	visited[row][col] = false; // Undo - backtrack
    	return false;
    }
}
