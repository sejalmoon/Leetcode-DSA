class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int max = n/3;

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int val = entry.getKey();
            int count = entry.getValue();

            if(count > max) ans.add(val);
        }

        return ans;
    }
}