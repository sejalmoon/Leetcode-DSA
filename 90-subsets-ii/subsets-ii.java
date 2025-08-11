class Solution {
    private void solve(int idx, int arr[], List<Integer> list, List<List<Integer>> result){
        result.add(new ArrayList<>(list));
        for(int i=idx; i<arr.length; i++){
            if(i>idx && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            solve(i+1, arr, list, result);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), result);
        return result;
    }
}