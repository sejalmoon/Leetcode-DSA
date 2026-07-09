class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] node = new int[n];
        node[0] = 0;

        for(int i = 1; i<n; i++){
            if(nums[i] - nums[i-1] <= maxDiff){
                node[i] = node[i-1];
            }else{
                node[i] = node[i-1] + 1;
            }
        }

        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i<queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = (node[u] == node[v]);
        }
        return ans;
    }
}