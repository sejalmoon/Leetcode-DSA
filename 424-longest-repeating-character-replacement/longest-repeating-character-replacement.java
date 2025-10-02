class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxfreq=0,maxlen=0;
        int[] hash=new int[26];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,hash[s.charAt(r)-'A']);
            if((r-l+1)-maxfreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxfreq<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}