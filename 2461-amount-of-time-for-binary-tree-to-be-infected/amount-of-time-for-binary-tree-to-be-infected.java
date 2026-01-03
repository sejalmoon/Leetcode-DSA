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

    private TreeNode parentMap(HashMap<TreeNode, TreeNode> mp, int start, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode target = new TreeNode();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val == start){
                target = node;
            }
            if(node.left != null){
                mp.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                mp.put(node.right, node);
                q.add(node.right);
            }
        }
        return target;
    }

    private int findMaxTime(HashMap<TreeNode, TreeNode> mp, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        HashMap<TreeNode, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0;

            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null){
                    flag = 1;
                    vis.put(node.left, 1);
                    q.add(node.left);
                }

                if(node.right != null && vis.get(node.right) == null){
                    flag = 1;
                    vis.put(node.right, 1);
                    q.add(node.right);
                }

                if(mp.get(node) != null && vis.get(mp.get(node)) == null){
                    flag = 1;
                    vis.put(mp.get(node), 1);
                    q.add(mp.get(node));
                }
            }
            if(flag == 1) maxi++;
        }
        return maxi;
    }


    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> mp = new HashMap<>();
        TreeNode target = parentMap(mp, start, root);
        int maxi = findMaxTime(mp, target);
        return maxi;
    }
}