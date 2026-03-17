class Solution {
    public int maximumDetonation(int[][] bombs) {
        int maxi = 0;
        int n = bombs.length;
        for(int i = 0; i<n; i++){
            maxi = Math.max(maxi, bfs(i, bombs));
        }
        return maxi;
    }

    public int bfs(int node, int[][] bombs){
        Queue<Integer> q = new LinkedList<>();
        int n = bombs.length;
        boolean[] visited = new boolean[n];

        visited[node] = true;
        q.add(node);
        int ans = 1;

        while(!q.isEmpty()){
            int ind = q.poll();
            for(int i = 0; i<n; i++){
                if(!visited[i] && inRange(bombs[ind], bombs[i])){
                    visited[i] = true;
                    ans++;
                    q.add(i);
                }
            }
        }
        return ans;
    }

    private boolean inRange(int[] p1, int[] p2){
        long dx = p1[0] - p2[0];
        long dy = p1[1] - p2[1];
        long r = p1[2];
        long dist = dx*dx + dy*dy;
        return dist <= r*r;
    }

}