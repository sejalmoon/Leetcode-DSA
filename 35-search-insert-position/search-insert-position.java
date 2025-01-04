class Solution {
    public int searchInsert(int[] nums, int target) {
        return bs(nums, 0, nums.length-1,target);
    }

    public int bs(int[] nums, int s, int e, int target){
        while(s<=e){
            int m=(s+e)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[m]<target){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
        return s;
    }
}