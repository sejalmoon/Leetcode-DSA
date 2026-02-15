class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        int n = nums.length;
        while(j<n){
            if(nums[j]!=nums[j-1]){
                nums[i]=nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}