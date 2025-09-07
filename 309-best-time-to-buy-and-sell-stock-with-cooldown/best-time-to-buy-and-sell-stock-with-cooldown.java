class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,n,prices,1,dp);
    }

    private int solve(int index, int n, int[] prices, int buy, int dp[][]){
        if(index>=n){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[index]+solve(index+1,n,prices,0,dp),solve(index+1,n,prices,1,dp));
        }
        else{
            profit = Math.max(prices[index]+solve(index+2,n,prices,1,dp), solve(index+1,n,prices,0,dp));
        }

        return dp[index][buy]=profit;
    }
}