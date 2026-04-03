class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int maxi = 0;
        int[][] vis = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    int count = dfs(i, j, grid, vis, m, n);
                    maxi = Math.max(maxi, count);
                }
            }
        }
        return maxi;
    }

    private int dfs(int row, int col, int[][] grid, int[][] vis, int m, int n){
        vis[row][col] = 1;
        int count = 1;
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, -1, 0, 1};
        for(int i = 0; i<4; i++){
            int nr = row + delr[i];
            int nc = col + delc[i];

            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == 1 && vis[nr][nc] == 0){
                count += dfs(nr, nc, grid, vis, m, n);
            }
        }
        return count;
    }
}