class Pair{
    int node;
    long wt;
    Pair(int node, long wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i<roads.length; i++){
            adjList.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adjList.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = Long.MAX_VALUE;
        }

        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.wt, y.wt));
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);
        while(pq.size() != 0){
            int node = pq.peek().node;
            long wt = pq.peek().wt;
            pq.remove();

            for(Pair it:adjList.get(node)){
                int adjNode = it.node;
                long edgewt = it.wt;

                if(wt + edgewt < dist[adjNode]){
                    dist[adjNode] = wt + edgewt;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
                else if(wt + edgewt == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}