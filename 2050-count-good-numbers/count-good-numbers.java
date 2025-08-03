class Solution {
    long MOD = (long) 1e9 + 7;

    public long power(long a, long b){
        if(b==0){
            return 1;
        }
        long half = power(a,b/2);
        if(b%2==0){
            return (half*half)%MOD;
        }
        else{
            return (half*half*a)%MOD;
        }
    }
    public int countGoodNumbers(long n) {
        long odd= n/2;
        long even = (n+1)/2;
        return (int)((power(5,even)*power(4,odd))%MOD);
    }
}