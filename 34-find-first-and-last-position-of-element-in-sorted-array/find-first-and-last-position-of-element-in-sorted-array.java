class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=nums.length;
        int last=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                first=Math.min(first,mid);
                right=mid-1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        left=0;
        right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                last=Math.max(last,mid);
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }

        if(first==nums.length){
            int[] ans = {-1,-1};
            return ans;
        }
        int[] ans = {first,last};
        return ans;

    }
}