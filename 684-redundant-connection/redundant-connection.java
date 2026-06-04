class Solution {

    class DisjointSet{
        private int n;
        private int[] size;
        private int[] parent;

        public DisjointSet(int n){
            this.n = n;
            size = new int[n];
            parent = new int[n];

            for(int i = 0; i<n; i++){
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        public boolean unionBySize(int u, int v){
            int p1 = findParent(u);
            int p2 = findParent(v);

            if(p1 == p2) return false;
            else{
                if(size[p1] > size[p2]){
                    parent[p2] = p1;
                    size[p1] += size[p2];
                }else{
                    parent[p1] = p2;
                    size[p2] += size[p1];
                }
                return true;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        for(int[] edge : edges){
            if(!ds.unionBySize(edge[0]-1, edge[1]-1)){
                return edge;
            }
        }
        return new int[]{};
    }
}