class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    bfs(i, j, grid, vis);
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

    private void bfs(int row, int col, char[][] grid, int[][] vis){
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        vis[row][col]=1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});

        while(!q.isEmpty()){
            int[] front = q.poll();
            for(int[] d:directions){
                int r = front[0]+d[0];
                int c = front[1]+d[1];
                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1' && vis[r][c]==0){
                    vis[r][c]=1;
                    q.add(new int[]{r,c});
                }
            }

        }
    }
}