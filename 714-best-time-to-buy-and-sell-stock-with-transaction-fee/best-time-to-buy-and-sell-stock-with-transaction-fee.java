class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=0;i<=n;i++){
            for(int buy=0;buy<2;buy++){
                dp[i][buy]=0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    dp[i][buy]=Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
                }
                else{
                    dp[i][buy]=Math.max(prices[i]-fee+dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }

    private int solve(int index,int n, int[] prices, int fee, int buy,int[][] dp){
        if(index==n){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        if(buy==1){
            profit = Math.max(-prices[index]+solve(index+1,n,prices,fee,0,dp),
                solve(index+1,n,prices,fee,1,dp));
        }
        else{
            profit = Math.max(prices[index]-fee+solve(index+1,n,prices,fee,1,dp),
                solve(index+1,n,prices,fee,0,dp));
        }
        return dp[index][buy]=profit;
    }
}