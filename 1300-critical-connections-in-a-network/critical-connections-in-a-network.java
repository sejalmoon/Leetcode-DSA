class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<connections.size(); i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int vis[] = new int[n];
        int low[] = new int[n];
        int step[] = new int[n];
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, -1, vis, adj, step, low, ans);

        return ans;
    }

    static int timer=1;
    void dfs(int node,int parent,int vis[],List<List<Integer>> adj,int step[],int low[],List<List<Integer>> ans){
        vis[node]=1;
        step[node]=timer;
        low[node]=timer;
        timer++;
        for(int i:adj.get(node)){
            if(i==parent)continue;
            if(vis[i]==0){
                dfs(i,node,vis,adj,step,low,ans);
                low[node]=Math.min(low[node],low[i]);
                if(low[i]>step[node]){
                    ans.add(List.of(node, i));
                }
            }
            else{
                low[node]=Math.min(low[node],low[i]);
            }
        }
    }
}