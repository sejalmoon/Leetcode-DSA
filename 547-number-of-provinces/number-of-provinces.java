class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i<n; i++){
            if(!vis[i]){
                dfs(i, n, vis, isConnected);
                count++;
            }
        }

        return count;
    }

    private void dfs(int ind, int n, boolean[] vis, int[][] isConnected){
        vis[ind]=true;
        for(int i=0; i<n; i++){
            if(isConnected[ind][i]==1 && !vis[i]){
                dfs(i, n, vis, isConnected);
            }
        }
    }
}