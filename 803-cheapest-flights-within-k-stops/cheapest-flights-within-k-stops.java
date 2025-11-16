class Pair{
    int node;
    int wt;
    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Tuple{
    int stops;
    int node;
    int wt;
    Tuple(int stops, int node, int wt){
        this.stops = stops;
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i<flights.length; i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));

        while(!q.isEmpty()){
            int stops = q.peek().stops;
            int node = q.peek().node;
            int wt = q.peek().wt;
            q.remove();

            if(stops>k){
                continue;
            }
            for(Pair it:adjList.get(node)){
                int adjNode = it.node;
                int edgewt = it.wt;

                if(wt + edgewt<dist[adjNode] && stops<=k){
                    dist[adjNode] = wt + edgewt;
                    q.add(new Tuple(stops+1, adjNode, wt + edgewt));
                }
            }

        }

        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dst];
        }

    }
}