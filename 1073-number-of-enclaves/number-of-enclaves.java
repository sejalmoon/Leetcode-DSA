class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i<m; i++){
            if(grid[i][0] == 1){
                dfs(i, 0, grid, vis, m, n);
            }
            if(grid[i][n-1] == 1){
                dfs(i, n-1, grid, vis, m, n);
            }
        }

        for(int i = 0; i<n; i++){
            if(grid[0][i] == 1){
                dfs(0, i, grid, vis, m, n);
            }
            if(grid[m-1][i] == 1){
                dfs(m-1, i, grid, vis, m, n);
            }
        }

        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] vis, int m, int n){
        vis[row][col] = true;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};
        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                dfs(nrow, ncol, grid, vis, m, n);
            }
        }
    }
}