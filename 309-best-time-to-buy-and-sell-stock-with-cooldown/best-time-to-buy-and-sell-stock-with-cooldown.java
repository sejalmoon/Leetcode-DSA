class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    dp[i][j]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }else{
                    dp[i][j]=Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
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