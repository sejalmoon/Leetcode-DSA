class Solution {
    public int longestNiceSubarray(int[] nums) {
        int bit=0;
        int start=0;
        int ans=0;

        for(int end=0;end<nums.length;end++){
            while((bit&nums[end])!=0){
                bit ^= nums[start];
                start++;
            }
            bit |= nums[end];
            ans=Math.max(ans,end-start+1);
        }
        return ans;
    }
}