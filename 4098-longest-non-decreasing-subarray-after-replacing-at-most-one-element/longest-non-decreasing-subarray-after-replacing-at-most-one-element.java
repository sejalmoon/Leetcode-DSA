class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxlen = 1;
        if(n==1 || n==2){
            return n;
        }
        for(int i = 0; i<n; i++){
            left[i]=1;
            right[i]=1;
        }

        for(int i=1;i<n;i++){
            if(nums[i]>=nums[i-1]){
                left[i]=left[i-1]+1;
            }
            maxlen = Math.max(maxlen, left[i]);
        }
        for(int i = n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                right[i]=right[i+1]+1;
            }
            maxlen = Math.max(maxlen, right[i]);
        }
        if(maxlen != n){
            maxlen++;
        }
        for(int i=1;i<n-1;i++){
            if(nums[i-1]<=nums[i+1]){
                maxlen = Math.max(maxlen, left[i-1]+right[i+1]+1);
            }
        }
        return maxlen;
    }
}