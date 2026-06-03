class Solution {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<connections.size(); i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }

        int[] vis = new int[n];
        int[] low = new int[n];
        int[] tin = new int[n];

        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, adj, vis, low, tin, ans);
        return ans;        
    }

    private void dfs(int node, int parent, List<List<Integer>> adj, int[] vis, int[] low, int[] tin, List<List<Integer>> ans){
        vis[node] = 1;
        low[node] = timer;
        tin[node] = timer;
        timer++;

        for(Integer it:adj.get(node)){
            if(it == parent) continue;

            if(vis[it] == 0){
                dfs(it, node, adj, vis, low, tin, ans);
                low[node] = Math.min(low[node], low[it]);
                if(tin[node] < low[it]){
                    ans.add(Arrays.asList(it, node));
                }
                
            }else{
                low[node] = Math.min(low[node], low[it]);
            }
        }

    }
}