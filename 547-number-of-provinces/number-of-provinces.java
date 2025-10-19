class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    temp.add(j);
                }
            }
            adj.add(temp);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,n,adj,vis);
                count++;
            }
        }
        return count;
    }

    private void dfs(int ind, int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis){        
        vis[ind]=true;
        for(int it:adj.get(ind)){
            if(!vis[it]){
                dfs(it,n,adj,vis);
            }
        }
    }
}