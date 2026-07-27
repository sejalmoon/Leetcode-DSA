class Solution {
    public int maxProduct(int[] nums) {
        int maxi = 0;
        int secmaxi = 0;
        for(int num : nums){
            if(num > maxi){
                secmaxi = maxi;
                maxi = num;
            }
            else{
                secmaxi = Math.max(secmaxi, num);
            }
        }
        return (maxi-1)*(secmaxi-1);
    }
}