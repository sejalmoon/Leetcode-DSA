class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int arr[]=new int[m+2];
        arr[0]=0;
        for(int i=0;i<m;i++){
            arr[i+1]=cuts[i];
        }
        arr[cuts.length+1]=n;
        Arrays.sort(arr);
        int dp[][]=new int[m+2][m+2];
        for(int i=0;i<m+2;i++){
            for(int j=0;j<m+2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(arr,1,m,dp);
    }

    public int solve(int arr[],int i,int j, int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = arr[j+1]-arr[i-1]+solve(arr,i,ind-1,dp)+solve(arr,ind+1,j,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
}