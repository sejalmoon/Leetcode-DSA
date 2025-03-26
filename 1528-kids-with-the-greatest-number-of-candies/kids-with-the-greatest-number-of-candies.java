class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxi=0;
        for(int i:candies){
            maxi=Math.max(i,maxi);
        }

        List<Boolean> ans=new ArrayList<>();
        for(int i:candies){
            ans.add(i+extraCandies>=maxi);
        }

        return ans;
    }
}