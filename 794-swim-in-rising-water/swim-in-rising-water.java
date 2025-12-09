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
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        List<int[]> cells = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cells.add(new int[]{grid[i][j], i, j});
            }
        }

        Collections.sort(cells, (a, b) -> a[0] - b[0]);
        boolean[][] activated = new boolean[n][n];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int[] cell : cells){
            int h = cell[0];
            int r = cell[1];
            int c = cell[2];

            activated[r][c] = true;
            int index = r * n + c;

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && activated[nr][nc]){
                    int adj = nr * n + nc;
                    ds.UnionBySize(index, adj);
                }
            }

            if(ds.findParent(0) == ds.findParent(n*n - 1)){
                return h;
            }
        }
        return -1;    
    }
}