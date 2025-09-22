class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        int l=0, len=0, maxlen=0;
        for(int r=0;r<n;r++){
            char c = s.charAt(r);
            if(mp.containsKey(c) && mp.get(c)>=l){
                l=mp.get(c)+1;
            }
            maxlen=Math.max(maxlen,r-l+1);
            mp.put(c,r);
        }
        return maxlen;
    }
}