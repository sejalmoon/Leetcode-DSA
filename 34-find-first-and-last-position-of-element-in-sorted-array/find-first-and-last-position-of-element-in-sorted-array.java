class Solution {
    public int compare(boolean state, int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1, result = -1;
        while (r >= l) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (state) r = mid - 1;
                else l = mid + 1;
            } else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int s = compare(true, nums, target);
        int e = compare(false, nums, target);
        return new int[]{s, e};
    }
}