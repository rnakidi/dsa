36. Valid Sudoku - https://leetcode.com/problems/valid-sudoku/description/ - MEDIUM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // All board values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if('.' == board[i][j]) {
                    continue;
                } else if (board[i][j] <= '0' || board[i][j] > '9') {
                    return false;
                }
            }
        }

        // All rows
        for (int i = 0; i < rows; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (set.contains(board[i][j])) {
                    return false;
                } else if ('.' != board[i][j]) {
                    set.add(board[i][j]);
                }
            }
        }
        // All cols
        for (int i = 0; i < rows; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (set.contains(board[j][i])) {
                    return false;
                } else if ('.' != board[j][i]) {
                    set.add(board[j][i]);
                }
            }
        }

        // 3x3
        for (int i = 0; i < rows - 2; i += 3) {        
            for (int j = 0; j < cols - 2; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int X = k + i;
                        int Y = l + j;
                        char ch = board[X][Y];
                        if (set.contains(ch)) {
                            return false;
                        } else if ('.' != ch) {
                            set.add(ch);
                        }
                    }
                }
            }
        }
        return true;
    }
}
