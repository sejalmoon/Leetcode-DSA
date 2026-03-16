class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                ans++;
                dfs(i, visited, isConnected);
            }
        }

        return ans;
    }

    public void dfs(int node, boolean[] visited, int[][] isConnected){
        visited[node] = true;
        int n = isConnected.length;
        for(int i = 0; i<n; i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfs(i, visited, isConnected);
            } 
        }
    }
}