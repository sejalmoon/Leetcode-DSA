class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return solve(0,n,arr,k,dp);
    }

    public int solve(int ind,int n,int[] arr,int k,int dp[]){
        if(ind==n){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int maxSum=0,len=0,maxi=Integer.MIN_VALUE;
        for(int i=ind;i<Math.min(n,ind+k);i++){
            len++;
            maxi=Math.max(maxi,arr[i]);
            int sum=(len*maxi)+solve(i+1,n,arr,k,dp);
            maxSum=Math.max(maxSum,sum);
        }
        return dp[ind]=maxSum;
    }
}