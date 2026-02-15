class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int rot = 0;
        for(int i = 0; i<n-1; i++){
            if(nums[i]>nums[i+1]) rot++;
        }
        if(rot == 0) return true;
        if(rot == 1 && nums[0]>=nums[n-1]) return true;
        else return false;
    }
}