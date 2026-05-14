class Tuple{
    int stops;
    int node;
    int wt;
    public Tuple(int stops, int node, int wt){
        this.stops = stops;
        this.node = node;
        this.wt = wt;
    }
}

class Pair{
    int node;
    int wt;
    public Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = (int)1e9;
        }

        dist[src] = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        while(!q.isEmpty()){
            Tuple t = q.peek();
            int stops = t.stops;
            int node = t.node;
            int wt = t.wt;
            q.remove();

            if(stops > k) continue;

            for(Pair p : adj.get(node)){
                int newNode = p.node;
                int newWt = p.wt;

                if(wt + newWt < dist[newNode] && stops<=k){
                    dist[newNode] = wt + newWt;
                    q.add(new Tuple(stops + 1, newNode, wt + newWt));
                }
            }
        }

        if(dist[dst] == (int)1e9){
            return -1;
        }else{
            return dist[dst];
        }
    }
}