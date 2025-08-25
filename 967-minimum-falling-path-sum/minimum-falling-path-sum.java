class Solution {
    private int solve(int[][] matrix, int i, int j, int n, int[][] dp){
       if(j<0 || j>=n){
        return Integer.MAX_VALUE;
       }
       if(i==0){
        return dp[0][j]=matrix[0][j];
       }
       if(dp[i][j]!=Integer.MAX_VALUE){
        return dp[i][j];
       }
       int s =  solve(matrix, i-1, j, n,dp);
       int ld = solve(matrix, i-1, j-1, n, dp);
       int rd = solve(matrix, i-1, j+1, n, dp);
       return Integer.min(s, Integer.min(ld,rd)) + matrix[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
                dp[i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            int curr[] = new int[n];
            for(int j=0;j<n;j++){
                int s = matrix[i][j] + dp[j];
                int ld = matrix[i][j];
                if(j-1>=0){
                    ld += dp[j-1];
                }
                else{
                    ld = Integer.MAX_VALUE;
                }
                int rd = matrix[i][j];
                if(j+1<=n-1){
                    rd += dp[j+1];
                }
                else{
                    rd= Integer.MAX_VALUE;
                }
                curr[j] = Integer.min(s, Integer.min(ld,rd));
            } 
            dp=curr;  
        }
        int mini = dp[0];
        for(int i=1;i<n;i++){
                mini=Integer.min(mini,dp[i]);
        }
        return mini;
    }
}