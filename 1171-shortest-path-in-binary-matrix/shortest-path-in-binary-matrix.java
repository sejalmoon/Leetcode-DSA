class Tuple{
    int row;
    int col;
    int wt;

    public Tuple(int row, int col, int wt){
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
                dist[i][j] = (int)1e9;
            }
        }

        dist[0][0] = 1;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
        pq.add(new Tuple(0, 0, 1));

        while(pq.size() != 0){
            Tuple t = pq.peek();
            pq.remove();

            int row = t.row;
            int col = t.col;
            int height = t.wt;

            if(row == n-1 && col == n-1) return height;

            for(int delrow = -1; delrow<=1; delrow++){
                for(int delcol = -1; delcol<=1; delcol++){
                    int newrow = row + delrow;
                    int newcol = col + delcol;
                    if(newrow>=0 && newrow<n && newcol>=0 && newcol<n && grid[newrow][newcol]==0 && height+1<dist[newrow][newcol]){
                        dist[newrow][newcol] = height + 1;
                        pq.add(new Tuple(newrow, newcol, height+1));
                    }             
                }
            }
        }
        return -1;
    }
}