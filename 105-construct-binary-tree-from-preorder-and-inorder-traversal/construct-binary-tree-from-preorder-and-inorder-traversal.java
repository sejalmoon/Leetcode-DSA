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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<n; i++){
            mp.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, n-1, inorder, 0, n-1, mp);
        return root;
    }

    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> mp){

        if(prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot = mp.get(root.val);
        int numsleft = inroot - instart;

        root.left = build(preorder, prestart+1, prestart + numsleft, inorder, instart, inroot -1, mp);

        root.right = build(preorder, prestart + numsleft + 1, preend, inorder, inroot + 1, inend, mp);
        return root;

    }
}