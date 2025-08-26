class Solution {
    private boolean solve(int index, int[] nums, int target, Boolean dp[][]){
        if(target==0){
            return true;
        }
        if(index==0){
            return (nums[0]==target);
        }

        if(dp[index][target]!=null){
            return dp[index][target];
        }

        boolean take = false;
        if(nums[index]<=target){
            take = solve(index-1, nums, target-nums[index], dp);
        }
        boolean notTake = solve(index-1, nums, target, dp);

        return dp[index][target] = take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        else{
            Boolean dp[][] = new Boolean[n][(sum/2) + 1];
            return solve(n-1, nums, sum/2, dp);
        }    
    }
}