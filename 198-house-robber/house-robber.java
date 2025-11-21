class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i<n; i++){
            int pick = nums[i];
            if(i>1){
                pick += prev2;
            }
            int notpick = prev;
            int curr = Math.max(pick, notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    private int helper(int ind, int[] nums, int[] dp){
        if(ind==0){
            return dp[0]=nums[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick = nums[ind] + helper(ind-2, nums, dp);
        int notpick = helper(ind-1, nums, dp);
        return dp[ind] = Math.max(pick, notpick);
    }
}