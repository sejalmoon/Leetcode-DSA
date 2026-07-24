class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int m = 0;
        for(int num : nums){
            m = Math.max(m, num);
        }
        int u = 1;
        while(u <= m){
            u <<= 1;
        }
        boolean[] one = new boolean[u];
        boolean[] two = new boolean[u];
        boolean[] three = new boolean[u];
        for(int num : nums){
            one[num] = true;
            for(int x = 0; x<u; x++){
                if(one[x]){
                    two[x^num] = true;
                }
            }
        }
        for(int num : nums){
            for(int x = 0; x<u; x++){
                if(two[x]){
                    three[x^num] = true;
                }
            }
        }
        int ans = 0;
        for(boolean b : three){
            if(b) ans++;
        }
        return ans;
    }
}