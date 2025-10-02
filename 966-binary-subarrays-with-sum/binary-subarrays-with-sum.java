class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums,goal)-f(nums,goal-1);
    }

    public int f(int[] nums, int goal){
        int l=0,r=0,count=0,sum=0;
        if(goal<0){
            return 0;
        }
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum=sum-nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}