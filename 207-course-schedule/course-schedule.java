class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(vis[i]==0){
                if(!dfs(i, vis, pathVis, adjList, st)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int ind, int[] vis, int[] pathVis, List<List<Integer>> adjList, Stack<Integer> st){
        vis[ind]=1;
        pathVis[ind]=1;
        for(int it:adjList.get(ind)){
            if(vis[it]==0){
                if(!dfs(it, vis, pathVis, adjList, st)){
                    return false;
                }
            }
            else if(pathVis[it]==1){
                return false;
            }
        }
        pathVis[ind]=0;
        st.add(ind);
        return true;
    }
}