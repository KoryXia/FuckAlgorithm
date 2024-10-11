/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start


class Solution {
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == start) {
                    if (backtrack(0, i, j, word, board)) {
                        return true;
                    }
                }
            }
        }
        return false;        
    }

    public boolean backtrack(int index, int row, int col, String word, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[row][col];
        board[row][col] = '#';
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (backtrack(index + 1, newRow, newCol, word, board)) {
                return true;
            }
        }
        
        board[row][col] = temp;
        return false;
    }
}
// @lc code=end

