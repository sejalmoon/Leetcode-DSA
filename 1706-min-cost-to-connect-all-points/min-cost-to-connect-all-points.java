class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int sum = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        Map<Integer, Integer> mp = new HashMap<>();
        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int cost = edge[0];
            int u = edge[1];

            if(visited[u]){
                continue;
            }

            visited[u] = true;
            sum += cost;

            for(int v = 0; v<n; v++){
                if(!visited[v]){
                    int dist = Math.abs(points[u][0] - points[v][0] )+ Math.abs(points[u][1] - points[v][1]);
                    if(dist < mp.getOrDefault(v, Integer.MAX_VALUE)){
                        mp.put(v, dist);
                        pq.add(new int[]{dist, v});
                    }
                }
            }
        }
        return sum;
    }
}