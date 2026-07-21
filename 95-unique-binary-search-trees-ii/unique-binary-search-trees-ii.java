/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> mp = new HashMap<>();
        return allPossibleBST(1, n, mp);
    }

    public List<TreeNode> allPossibleBST(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>>  mp){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end){
            ans.add(null);
            return ans;
        }
        if(mp.containsKey(new Pair<>(start, end))){
            return mp.get(new Pair(start, end));
        }

        for(int i = start; i<=end; i++){
            List<TreeNode> left = allPossibleBST(start, i-1, mp);
            List<TreeNode> right = allPossibleBST(i+1, end, mp);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i, l, r);
                    ans.add(root);
                }
            }
        }
        mp.put(new Pair<>(start, end), ans);
        return ans;
    }
}