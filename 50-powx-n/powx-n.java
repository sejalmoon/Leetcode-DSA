class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(x==1){
            return x;
        }
        if(x==-1 && n%2==0){
            return 1;
        }
        if(x==-1 && n%2!=0){
            return -1;
        }
        if(x<1 && x>0 && n==Integer. MAX_VALUE){
            return 0;
        }

        if(n==Integer.MIN_VALUE){
            return 0;
        }
        if(n<0){
            return 1/myPow(x,-n);
        }
        return x*myPow(x,n-1);
        

    }
}