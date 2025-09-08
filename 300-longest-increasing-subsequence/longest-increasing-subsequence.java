class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       int dp[][] = new int[n+1][n+1];
       for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            dp[i][j]=0;
        }
       }

       for(int ind=n-1;ind>=0;ind--){
        for(int prevIndex=ind-1;prevIndex>=-1;prevIndex--){
            int notTake = dp[ind+1][prevIndex+1];
            int take = 0;
            if(prevIndex==-1 || nums[ind]>nums[prevIndex]){
                take = 1 + dp[ind+1][ind+1];
            }
            dp[ind][prevIndex+1] = Math.max(take,notTake);
        }
       }

       return dp[0][0];
    }

    private int solve(int index, int n, int[] nums, int prevIndex, int dp[][]){
        if(index==n){
            return 0;
        }

        if(dp[index][prevIndex+1]!=-1){
            return dp[index][prevIndex+1];
        }

        int take = 0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            take = 1 + solve(index+1,n,nums,index,dp);
        }
        int notTake = solve(index+1,n,nums,prevIndex,dp);

        return dp[index][prevIndex+1]=Math.max(take,notTake);
    }
}