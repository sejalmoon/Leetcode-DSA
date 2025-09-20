class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return solve(0,n,s,dp)-1;
    }

    public int solve(int i, int n, String s, int dp[]){
        if(i==n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<n;ind++){
            if(isPalindrome(i,ind,s)){
                int cost = 1+solve(ind+1,n,s,dp);
                mini=Math.min(mini,cost);
            }
        }
        return dp[i]=mini;
    }

    public boolean isPalindrome(int i, int j, String s){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}