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
    public boolean isSymmetric(TreeNode root) {

        if(root==null){
            return true;
        }
        boolean ans=isMirror(root.left,root.right);
        return ans;
    }

    public boolean isMirror(TreeNode lr, TreeNode rr){
        
        if(lr==null && rr==null){
            return true;
        }
        if(lr==null || rr==null){
            return false;
        }

        if(lr.val!=rr.val){
            return false;
        }


        boolean ans1=isMirror(lr.left,rr.right);
        boolean ans2=isMirror(lr.right,rr.left);
        if(ans1==true && ans2==true){
            return true;
        }
        else{
            return false;
        }
    }
}