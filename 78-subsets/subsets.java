import java.util.*;

class Solution {
    public void generateSubsets(int[] nums, List<Integer> current, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Include the current number
        current.add(nums[index]);
        generateSubsets(nums, current, index + 1, ans);

        // Backtrack and exclude the current number
        current.remove(current.size() - 1);
        generateSubsets(nums, current, index + 1, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums, new ArrayList<>(), 0, ans);
        return ans;
    }
}