class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int count = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == 1){
                count++;
            }
            else{
                count = 0;
            }
            maxi = Math.max(count, maxi);
        }
        return maxi;
        
    }
}