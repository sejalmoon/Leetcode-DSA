class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] maxi = new int[n];
        int premaxi = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            premaxi = Math.max(premaxi, nums[i]);
            maxi[i] = premaxi;
        }

        int[] pregcd = new int[n];
        for(int i = 0; i<n; i++){
            pregcd[i] = gcd(nums[i], maxi[i]);
        }

        Arrays.sort(pregcd);
        long ans = 0;
        int l = 0;
        int r = n-1;
        while(l < r){
            ans+= gcd(pregcd[l], pregcd[r]);
            l++;
            r--;
        }
        return ans;

    }

    private int gcd(int x, int y){
        if(y == 0) return x;
        else return gcd(y, x%y);
    }
}