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

class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushLeft(root);
    }

    private void pushLeft(TreeNode root){
        while(root != null){
            st.add(root);
            if(reverse){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    public int next(){
        TreeNode temp = st.pop();
        if(reverse) pushLeft(temp.left);
        else{
            pushLeft(temp.right);
        }
        return temp.val;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j == k) return true;
            if(i+j < k){
                i = l.next();
            }
            else{
                j = r.next();
            }
        }
        return false;
    }
}