class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]==0){
                dfs(0,i,vis,board,delrow,delcol);
            }
            if(board[n-1][i]=='O' && vis[n-1][i]==0){
                dfs(n-1,i,vis,board,delrow,delcol);
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(i,0,vis,board,delrow,delcol);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(i,m-1,vis,board,delrow,delcol);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }

    private void dfs(int row, int col, int[][] vis, char[][] board, int[] delrow, int[] delcol){
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = 1;
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' && vis[nrow][ncol]==0){
                dfs(nrow, ncol, vis, board, delrow, delcol);
            }
        }
    }
}