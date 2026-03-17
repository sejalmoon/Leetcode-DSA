class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int maxi = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r = bombs[i][2];

            for(int j = 0; j<n; j++){
                if(i==j) continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x1 - x2;
                long dy = y1 - y2;
                long dist = dx*dx + dy*dy;
                
                if(dist <= r*r){
                    adj.get(i).add(j);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            boolean[] visited = new boolean[n];
            ans = Math.max(ans, dfs(i, adj, visited));
        }

        return ans;
        
    }

    private int dfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;
        int count = 1;
        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                count += dfs(neigh, adj, visited);
            }
        }
        return count;
    }
}