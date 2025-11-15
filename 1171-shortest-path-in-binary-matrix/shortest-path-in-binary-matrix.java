class Tuple{
    int row;
    int col;
    int wt;
    Tuple(int row, int col, int wt){
        this.row = row;
        this.col = col;
        this.wt = wt;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }
        int[][] dist = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }  
        dist[0][0] = 1;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,1));

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int wt = q.peek().wt;
            q.remove();
            if (row == n-1 && col == n-1){
                return wt;
            }
            for(int delrow = -1; delrow<=1; delrow++){
                for(int delcol = -1; delcol<=1; delcol++){
                    int newrow = row + delrow;
                    int newcol = col + delcol;
                    if(newrow>=0 && newrow<n && newcol>=0 && newcol<n && grid[newrow][newcol]==0 && wt+1<dist[newrow][newcol]){
                        dist[newrow][newcol] = wt + 1;
                        q.add(new Tuple(newrow, newcol, wt+1));
                    }
                }
            }
        }
        return -1;
    }
}