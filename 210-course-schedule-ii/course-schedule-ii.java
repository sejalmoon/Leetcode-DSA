class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<numCourses; i++){
            if(vis[i] == 0){
                if(!dfs(i, numCourses, adj, vis, pathVis, st)) return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }

    private boolean dfs(int node, int n, List<List<Integer>> adj, int[] vis, int[] pathVis, Stack<Integer> st){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                if(!dfs(it, n, adj, vis, pathVis, st)) return false;
            }
            else if(pathVis[it] == 1){
                return false;
            }
        }
        pathVis[node] = 0;
        st.add(node);
        return true;
    }
}