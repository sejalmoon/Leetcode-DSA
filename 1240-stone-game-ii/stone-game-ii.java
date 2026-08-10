class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];

        int[] suffixSum = new int[n+1];
        for(int i = n-1; i>=0; i--){
            suffixSum[i] = suffixSum[i+1] + piles[i];
        }

        for(int i = 0; i<=n; i++){
            dp[i][n] = suffixSum[i];
        }

        for(int ind=n-1; ind>=0; ind--){
            for(int maxi = n-1; maxi>=1; maxi--){
                for(int x = 1; x<=2*maxi && ind+x<=n; x++){
                    dp[ind][maxi] = Math.max(dp[ind][maxi], suffixSum[ind] - dp[ind+x][Math.max(maxi, x)]);
                }
            }
        }
        return dp[0][1];
    }
}