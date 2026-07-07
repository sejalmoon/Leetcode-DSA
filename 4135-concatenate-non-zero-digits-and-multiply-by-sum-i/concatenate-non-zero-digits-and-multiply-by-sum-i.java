class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        int pow = 1;
        while(n > 0){
            int r = n%10;
            sum += r;
            if(r > 0){
                x+= r*pow;
                pow *= 10;
            }
            n = n/10;
        }
        return x*sum;
    }
}