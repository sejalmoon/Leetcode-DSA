class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid, int[][] vis){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0' || vis[row][col]==1){
            return;
        }
        vis[row][col] = 1;

        dfs(row-1,col,grid,vis);
        dfs(row,col-1,grid,vis);
        dfs(row+1,col,grid,vis);
        dfs(row,col+1,grid,vis);        
    }
}