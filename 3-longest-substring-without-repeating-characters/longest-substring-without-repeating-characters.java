class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        int i=0;
        Map<Character,Integer> mp = new HashMap<>();

        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            if(mp.containsKey(c) && mp.get(c)>=i){
                i = mp.get(c) + 1;
            }
            count=Math.max(count,j-i+1);
            mp.put(c,j);
        }
        return count;
    }
}