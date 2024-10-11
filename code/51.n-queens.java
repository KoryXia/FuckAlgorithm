/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtracking(board, n, 0);
        return res;
    }

    public void backtracking(char[][] board, int n, int row) {
        if (row == n) {
            res.add(array2List(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n, board)) {
                board[row][i] = 'Q';
                backtracking(board, n, row + 1);
                board[row][i] = '.';
            }
        }
    }


    public List<String> array2List(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }


        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
