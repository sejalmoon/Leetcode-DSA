class Solution {
    public int numTrees(int n) {
        int[] tree = new int[n+1];
        for(int i = 0; i<=n; i++){
            tree[i] = 1;
        }

        for(int node = 2; node<=n; node++){
            int total = 0;
            for(int root = 1; root<=node; root++){
                total += tree[root-1]*tree[node-root];
            }
            tree[node] = total;
        }
        return tree[n];
    }
}