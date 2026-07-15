class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n*n;
        int sumEven = n*(n+1);
        return gcd(sumOdd, sumEven);
    }

    private int gcd(int x, int y){
        if(y == 0){ 
            return x;
        }else{
            return gcd(y, x%y);
        }       
    }
}