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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int level = q.size();
            for(int i = 0; i<level; i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek(). right != null) q.add(q.peek().right);
                l.add(q.poll().val);
            }
            if(count%2 != 0){
                Collections.reverse(l);
            }
            ans.add(l);
            count++;
        }
        return ans;
    }
}