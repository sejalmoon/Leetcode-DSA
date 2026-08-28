class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        boolean hasOddFreq = false;
        for(int fr  : freq.values()){
            if(fr % 2 == 0){
                ans+= fr;
            }else{
                ans+= fr-1;
                hasOddFreq = true;
            }
        }

        if(hasOddFreq) return ans + 1;

        return ans;
    }
}