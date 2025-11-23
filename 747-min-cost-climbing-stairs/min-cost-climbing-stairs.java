class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(solve(cost, 0, n, dp), solve(cost, 1, n, dp));
    }

    private int solve(int[] cost, int ind, int n, int[] dp){
        if(ind >= n){
            return 0;
        }

        if(dp[ind]!=-1){
            return dp[ind];
        }

        int one = cost[ind] + solve(cost, ind+1, n, dp);
        int two = cost[ind] + solve(cost, ind+2, n, dp);
        return dp[ind] = Math.min(one, two);
    }
}