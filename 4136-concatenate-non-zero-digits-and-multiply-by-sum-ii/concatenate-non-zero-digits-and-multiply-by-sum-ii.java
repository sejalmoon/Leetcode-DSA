class Solution {

    private static final int mod = 1_000_000_007;    
    private static final int max = 100001;
    private static final int[] pow = new int[max];

    static{
        pow[0] = 1;
        for(int i = 1; i<max; i++){
            pow[i] = (int) (((long) pow[i - 1] * 10) % mod);        
        }
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n+1];
        int[] prefix = new int[n+1];
        int[] len = new int[n+1];
        for(int i = 0; i<n; i++){
            int d = s.charAt(i) - '0';
            sum[i + 1] = sum[i] + d;

            if(d > 0){
                prefix[i + 1] = (int) (((long) prefix[i] * 10 + d) % mod);                
                len[i+1] = len[i] + 1;
            }else{
                prefix[i+1] = prefix[i];
                len[i+1] = len[i];
            }
        }

        int[] ans = new int[queries.length];
        int i = 0;

        for(int[] q:queries){
            int l = q[0];
            int r = q[1] + 1;

            long sub = ((long) prefix[l]*pow[len[r] - len[l]])%mod;
            long x = (prefix[r] - sub + mod)%mod;

            ans[i++] = (int)((x * (sum[r] - sum[l])) % mod);
        }
        return ans;
    }
}