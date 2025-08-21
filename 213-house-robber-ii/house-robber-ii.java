class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int ans1=solve(nums, 0, nums.length-2);
        int ans2=solve(nums, 1, nums.length-1);

        return Math.max(ans1, ans2);

    }

    public int solve(int[] nums, int start, int end){
        int prev = nums[start];
        int prev2 = 0;

        for(int i=start+1;i<=end;i++){
            int take = nums[i];
            if(i>start+1){
                take+=prev2;
            }
            int nottake = prev;
            int curr = Math.max(take, nottake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}