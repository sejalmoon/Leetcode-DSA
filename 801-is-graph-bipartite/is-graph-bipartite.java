class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,graph)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int ind, int col, int[] color, int[][] graph){
        color[ind]=col;
        for(int it:graph[ind]){
            if(color[it]==-1){
                if(dfs(it,1-col,color,graph)==false){
                    return false;
                }
            }
            else if(color[it]==col){
                return false;
            }
        }
        return true;
    }
}