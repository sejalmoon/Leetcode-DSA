class Pair{
    int node;
    int wt;
    public Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        int[] dist = new int[n+1];
        for(int i = 0; i<n+1; i++){
            dist[i] = (int)1e9;
        }

        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt-y.wt);
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair p = pq.peek();
            int node = p.node;
            int wt = p.wt;
            pq.remove();

            for(Pair it:adj.get(node)){
                int newNode = it.node;
                int newWt = it.wt;

                if(wt + newWt < dist[newNode]){
                    dist[newNode] = wt + newWt;
                    pq.add(new Pair(newNode, dist[newNode]));
                }
            }

        }

        int ans = 0;
        for(int i = 1; i<n+1; i++){
            if(dist[i] == (int)1e9){
                return -1;
            }
            else{
                ans = Math.max(ans, dist[i]);
            }
        }
        return ans;
        
    }
}