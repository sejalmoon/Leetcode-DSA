class Solution {
    public boolean uniformArray(int[] nums1) {
        int mini = nums1[0];
        boolean ans = false;
        for(int num : nums1){
            if(num < mini){
                mini = num;
            }
            if((num & 1) == 1){
                ans = true;
            }
        }
        if((mini & 1) == 1){
            return true;
        }
        return !ans;
    }
}