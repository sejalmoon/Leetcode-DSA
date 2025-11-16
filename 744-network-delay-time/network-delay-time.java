class Pair{
    int node;
    int wt;
    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        for(int i = 0; i<n+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i<times.length; i++){
            adjList.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        dist[k] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((x,y) -> x.wt-y.wt);
        q.add(new Pair(k,0));
        while(!q.isEmpty()){
            int wt = q.peek().wt;
            int node = q.peek().node;
            q.remove();
            
            for(Pair it:adjList.get(node)){
                int adjNode = it.node;
                int edgewt = it.wt;

                if(wt + edgewt < dist[adjNode]){
                    dist[adjNode] = wt + edgewt;
                    q.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<n+1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}