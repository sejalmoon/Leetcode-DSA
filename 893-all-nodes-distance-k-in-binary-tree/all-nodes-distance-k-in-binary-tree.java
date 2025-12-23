/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
                parent.put(curr.left, curr);
            }
            if(curr.right != null){
                q.offer(curr.right);
                parent.put(curr.right, curr);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        vis.put(target, true);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k) break;

            level++;
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && vis.get(curr.left) == null){
                    q.offer(curr.left);
                    vis.put(curr.left, true);
                }

                if(curr.right != null && vis.get(curr.right) == null){
                    q.offer(curr.right);
                    vis.put(curr.right, true);
                }

                if(parent.get(curr) != null && vis.get(parent.get(curr)) == null){
                    q.offer(parent.get(curr));
                    vis.put(parent.get(curr), true);
                }
            }
        }

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            ans.add(curr.val);
        }
        return ans;
    }
}