class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }

    public int solve(int[] nums, int k){
        int l=0,r=0,count=0,sum=0;
        if(k<0){
            return 0;
        }
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>k){
                sum=sum-(nums[l]%2);
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}