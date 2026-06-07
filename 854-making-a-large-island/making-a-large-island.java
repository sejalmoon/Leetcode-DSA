class Solution {

    class DisjointSet{

        private int[] parent;
        private int[] size;
        private int n;
        public DisjointSet(int n){
            this.n = n;
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findparent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findparent(parent[node]);
        }

        public void unionBySize(int u, int v){
            int p1 = findparent(u);
            int p2 = findparent(v);

            if(p1 == p2) return;
            else{
                if(size[p1] > size[p2]){
                    parent[p2] = p1;
                    size[p1] += size[p2];
                }
                else{
                    parent[p1] = p2;
                    size[p2] += size[p1];
                }
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n*n);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int[] delrow = {-1, 0, 1, 0};
                int[] delcol = {0, -1, 0, 1};
                if(grid[i][j] == 1){
                    for(int k = 0; k<4; k++){
                        int nrow = i + delrow[k];
                        int ncol = j + delcol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 1){
                            int node = i*n + j;
                            int adjnode = nrow*n + ncol;
                            ds.unionBySize(node, adjnode);
                        }
                    }
                }
            }
        }

        int maxi = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                Set<Integer> s = new HashSet<>();
                if(grid[i][j] == 1) continue;
                if(grid[i][j] == 0){
                    int[] delrow = {-1, 0, 1, 0};
                    int[] delcol = {0, -1, 0, 1};
                    for(int k = 0; k<4; k++){
                        int nrow = i + delrow[k];
                        int ncol = j + delcol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 1){
                            s.add(ds.findparent(nrow*n + ncol));
                        }
                    }
                }

                int sizemax = 0;
                for(Integer par : s){
                    sizemax += ds.size[par];
                }

                maxi = Math.max(maxi, sizemax + 1);
            }
        }

        for(int i = 0; i<n*n; i++){
            maxi = Math.max(maxi, ds.size[ds.findparent(i)]);
        }
        return maxi;
    }
}