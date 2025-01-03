class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans=0;
        long sum1=0;
        int n=nums.length;
        long sum2=0;
        for(int i=0;i<n;i++){
            sum2+=nums[i];
        }
        for(int i=0;i<n-1;i++){
            sum1+=nums[i];
            sum2-=nums[i];
            if(sum1>=sum2){
                ans++;
            }
        
        }
        return ans;
    }
}