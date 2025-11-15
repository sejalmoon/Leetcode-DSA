class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            for(int it:graph[i]){
                adjList.get(it).add(i);
                indegree[i]++;
            }
        }

        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int ele = q.peek();
            q.remove();
            ans.add(ele);
            for(int it:adjList.get(ele)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}