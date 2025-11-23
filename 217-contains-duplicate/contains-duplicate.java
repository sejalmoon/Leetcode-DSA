class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num:nums){
            if(mp.containsKey(num)){
                return true;
            }
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        return false;
    }
}