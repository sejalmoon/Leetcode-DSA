class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }
        int ans = k;
        while(st.contains(ans)){
            ans += k;
        }
        return ans;
    }
}