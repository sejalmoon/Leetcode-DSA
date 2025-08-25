class Solution {
    private int solve(int i, int j, List<List<Integer>> triangle, int n,int[][] dp){
        if(i==n-1){
            return triangle.get(n-1).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int d = solve(i+1, j, triangle, n,dp) + triangle.get(i).get(j);
        int dg = solve(i+1, j+1, triangle, n,dp) + triangle.get(i).get(j);
        return dp[i][j]=Integer.min(d,dg);
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Integer.min(d,dg);
            }
        }
        return dp[0][0];
    }
}