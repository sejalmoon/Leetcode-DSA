class Pair{
    int node;
    long wt;
    public Pair(int node, long wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<roads.length; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        int mod = (int)(1e9 + 7);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.wt, y.wt));
        pq.add(new Pair(0, 0));
        long[] dist = new long[n];
        int[] ways = new int[n];

        for(int i = 0; i<n; i++){
            dist[i] = Long.MAX_VALUE;
        }
        dist[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty()){
            Pair p = pq.peek();
            int node = p.node;
            long wt = p.wt;
            pq.remove();

            for(Pair it:adj.get(node)){
                int newNode = it.node;
                long newWt = it.wt;

                if(newWt + wt < dist[newNode]){
                    dist[newNode] = newWt + wt;
                    ways[newNode] = ways[node];
                    pq.add(new Pair(newNode, dist[newNode]));
                }
                else if(newWt + wt == dist[newNode]){
                    ways[newNode] = (ways[newNode] + ways[node])%mod;
                }
            }
        }

        return ways[n-1]%mod;
    }
}