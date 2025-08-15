import java.util.*;

class Solution {
    public boolean isSafe(char[][] board, int row, int col, int n) {
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public void nQueens(char[][] board, int col, int n, List<List<String>> result) {
        if (col == n) {
            List<String> boardList = new ArrayList<>();
            for (char[] chars : board) {
                boardList.add(new String(chars));
            }
            result.add(boardList);
            return;
        }

        for (int i = 0; i < n; i++) { // try all rows in this column
            if (isSafe(board, i, col, n)) {
                board[i][col] = 'Q';
                nQueens(board, col + 1, n, result);
                board[i][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nQueens(board, 0, n, result);
        return result;
    }
}
