class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int num : nums) numsSet.add(num);

        int ans = 0;
        for(int num : numsSet){
            if(!numsSet.contains(num - 1)){
                int length = 1;

                while(numsSet.contains(num + length)){
                    length++;
                }

                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}