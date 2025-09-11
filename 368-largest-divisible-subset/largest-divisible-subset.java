class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int maxi=1;
        int lastIndex=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=i;
        }

        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            ans.add(nums[lastIndex]);
        }

        Collections.reverse(ans);
        return ans;
    }
}