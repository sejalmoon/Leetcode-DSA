class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i<n; i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findParent(int node){
        if(parent.get(node)!=node){
            parent.set(node, findParent(parent.get(node)));
        }
        return parent.get(node);
    }

    public void UnionByRank(int u, int v){
        int p1 = findParent(u);
        int p2 = findParent(v);
        if(p1 == p2){
            return;
        }
        if(rank.get(p1) < rank.get(p2)){
            parent.set(p1, p2);
        }
        else if(rank.get(p1) > rank.get(p2)){
            parent.set(p2, p1);
        }
        else{
            parent.set(p2, p1);
            rank.set(p1, rank.get(p1)+1);
        }
    }

    public void UnionBySize(int u, int v){
        int p1 = findParent(u);
        int p2 = findParent(v);
        if(p1 == p2){
            return;
        }
        if(size.get(p1) < size.get(p2)){
            parent.set(p1, p2);
            size.set(p2, size.get(p1) + size.get(p2));
        }
        else{
            parent.set(p2, p1);
            size.set(p1, size.get(p1) + size.get(p2));
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        for(int i = 0; i<n ; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 0) continue;
                int[] delrow = {-1, 0, 1, 0};
                int[] delcol = {0, 1, 0, -1};
                for(int ind = 0; ind<4; ind++){
                    int nrow = i + delrow[ind];
                    int ncol = j + delcol[ind];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        int node = i*n + j;
                        int adjNode = nrow*n + ncol;
                        ds.UnionBySize(node, adjNode);
                    }
                }
            }
        }

        int maxi = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1) continue;
                int[] delrow = {-1, 0 ,1 , 0};
                int[] delcol = {0, 1, 0, -1};
                Set<Integer> s = new HashSet<>();
                for(int ind = 0; ind<4; ind++){
                    int nrow = i + delrow[ind];
                    int ncol = j + delcol[ind];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 1){
                        s.add(ds.findParent(nrow*n + ncol));
                    }
                }

                int size = 0;
                for(Integer par : s){
                    size += ds.size.get(par);
                }
                maxi = Math.max(maxi, size + 1);
            }
        }

        for(int i = 0; i<n*n; i++){
            maxi = Math.max(maxi, ds.size.get(ds.findParent(i)));
        }
        return maxi;

    }
}