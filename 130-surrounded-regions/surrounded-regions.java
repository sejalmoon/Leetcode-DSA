class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];
        for(int i = 0; i<m; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board, vis, m, n);
            }
            if(board[i][n-1] == 'O'){
                dfs(i, n-1, board, vis, m, n);
            }
        }

        for(int i = 0; i<n; i++){
            if(board[0][i] == 'O'){
                dfs(0, i, board, vis, m, n);
            }
            if(board[m-1][i] == 'O'){
                dfs(m-1, i, board, vis, m, n);
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board, int[][] vis, int m, int n){
        vis[row][col] = 1;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0){
                dfs(nrow, ncol, board, vis, m, n);
            }
        }
    }
}