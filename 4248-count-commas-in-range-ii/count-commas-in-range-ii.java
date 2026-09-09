class Solution {
    public long countCommas(long n) {
        long big = 999;
        long ans = 0;
        while(n > big){
            ans += n - big;
            big = big * 1000 + 999;
        }
        return ans;
    }
}