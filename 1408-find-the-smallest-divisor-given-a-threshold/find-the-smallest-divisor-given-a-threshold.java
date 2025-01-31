class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length, min = 1;
        int low = 1, high = 1000000;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(result(nums, mid, threshold)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    private boolean result(int nums[], int divisor, int threshold){
        int ans = 0;
        for(int i : nums){
            ans += Math.ceilDiv(i, divisor);
        }
        return ans <= threshold;
    }
}