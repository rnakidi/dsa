51. N-Queens - https://leetcode.com/problems/n-queens/description/?envType=problem-list-v2&envId=array
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9

class Solution {
    public List<List<String>> solveNQueens(int n) {
    	char[][] board = new char[n][n];
    	for (char[] b : board) {
    		Arrays.fill(b, '.');
    	}
    	
    	List<List<String>> ans = new ArrayList<>();
    	helper(board, 0, n, ans);
        return ans;
    }
    
    private void helper(char[][] board, int row , int n, List<List<String>> ans) {
    	if (row == n) { // Goal reached, collect it and return
    		ans.add(Arrays.stream(board).map(String::new).toList());
    		return;
    	}
    	
    	// Explore possibilities or choices
    	for (int col = 0; col < n; col++) {
    		if (isValidMove(board, row, col, n)) {
    			board[row][col] = 'Q'; // Make/explore a choice
    			helper(board, row + 1, n, ans); // Make next choice or explore further
    			board[row][col] = '.'; // Undo backtrack
    		}
    	}
    }
    
    private boolean isValidMove(char[][] board, int row, int col, int n)    {      
    	// There is any queen in that column
    	for (int i = 0; i < n; i++) {
    		if ('Q' == board[i][col]) {
    			return false;
    		}    				
    	}
    	
    	// Upper-left
    	for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
    		if ('Q' == board[i][j]) {
    			return false;
    		}
    	}
    	
    	// Upper-right
    	for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
    		if ('Q' == board[i][j]) {
    			return false;
    		}
    	}
    	
    	// No conflict
    	return true;
    }
}
