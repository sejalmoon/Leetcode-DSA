class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mini = new int[n];
        mini[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--){
            mini[i] = Math.min(mini[i+1], nums[i]);
        }

        int maxi = 0;
        for(int i = 0; i<n; i++){
            maxi = Math.max(maxi, nums[i]);
            if(maxi - mini[i] <= k){
                return i;
            }
        }
        return -1;
    }
}