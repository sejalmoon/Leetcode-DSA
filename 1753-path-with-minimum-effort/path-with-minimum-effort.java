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
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
        pq.add(new Tuple(0,0,0));

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(pq.size() != 0){
            int row = pq.peek().row;
            int col = pq.peek().col;
            int wt = pq.peek().wt;
            pq.remove();

            if (wt > dist[row][col]) continue;

            if (row == n-1 && col == m-1)
                return wt;

            for(int i = 0; i<4; i++){
                int newrow = row + delrow[i];
                int newcol = col + delcol[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m){

                    int currJump = Math.abs(heights[row][col] - heights[newrow][newcol]);

                    int newEffort = Math.max(wt, currJump);
                    if (newEffort < dist[newrow][newcol]) {
                        dist[newrow][newcol] = newEffort;
                        pq.add(new Tuple(newrow, newcol, newEffort));
                    }
                }
            }
        }

        return dist[n-1][m-1];
    }
}