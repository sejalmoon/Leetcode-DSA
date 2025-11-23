class Solution {
    public int reverse(int x) {
        int rev = 0;
        int sign = 1;
        if(x<0){
            x = -x;
            sign=-1;
        }
        while(x>0){
            int digit = x%10;
            x = x/10;
            if(rev>Integer.MAX_VALUE/10){
                return 0;
            }
            rev = (rev*10) + digit;
        }
        return sign*rev;
    }
}