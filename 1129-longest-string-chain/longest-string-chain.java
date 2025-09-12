class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(check(words[i],words[prev]) && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
            }
        }
        return maxi;
    }

    private boolean check(String s1, String s2){
        if(s1.length()!=s2.length()+1){
            return false;
        }
        int first=0;
        int second=0;
        while(first<s1.length()){
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        if(first==s1.length() && second==s2.length()){
            return true;
        }
        return false;
    }
}