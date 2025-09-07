class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int lastbuy,lastsell,currbuy,currsell;
        lastbuy=0;
        lastsell=0;
        for(int i=n-1;i>=0;i--){
            currbuy=Math.max(-prices[i]+lastsell, lastbuy);
            currsell = Math.max(prices[i]-fee+lastbuy,lastsell);
            lastbuy=currbuy;
            lastsell=currsell;
        }
        return lastbuy;
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