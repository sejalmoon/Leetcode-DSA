class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, -1, 0, 1};

        int[][] dist = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dist[i], -1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{grid.get(0).get(0), 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int val = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(dist[row][col] >= 0) continue;
            dist[row][col] = val;
            for(int i = 0; i<4; i++){
                int nrow = row + delr[i];
                int ncol = col + delc[i];

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && dist[nrow][ncol]<0){
                    pq.add(new int[]{val + grid.get(nrow).get(ncol), nrow, ncol});
                }
            }
        }
        return dist[m-1][n-1] < health;
    }
}