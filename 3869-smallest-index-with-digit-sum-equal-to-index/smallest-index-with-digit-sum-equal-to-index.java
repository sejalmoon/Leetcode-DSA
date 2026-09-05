class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(i == sum(nums[i])) return i;
        }
        return -1;
    }

    private int sum(int num){
        int ans = 0;
        while(num > 0){
            ans += num % 10;
            num = num/10;
        }
        return ans;
    }
}