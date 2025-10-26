class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = 2;
                }
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        int tm = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int count = 0;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.peek()[2];
            q.remove();
            tm = Math.max(t,tm);
            for(int i=0;i<4;i++){
                int nr = r + delrow[i];
                int nc = c + delcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0){
                    q.add(new int[]{nr,nc,t+1});
                    vis[nr][nc] = 2;
                    count++;
                }
            }
        }

        if(count!=countFresh){
            return -1;
        }
        return tm;
    }
}