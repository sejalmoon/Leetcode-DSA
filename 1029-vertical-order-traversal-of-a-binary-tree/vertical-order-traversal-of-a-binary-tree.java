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
class Tuple{
    TreeNode node;
    int vertical;
    int level;
    public Tuple(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add( new Tuple(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        while(!q.isEmpty()){
            TreeNode node = q.peek().node;
            int vertical = q.peek().vertical;
            int level = q.peek().level;
            q.poll();

            if(!mp.containsKey(vertical)){
                mp.put(vertical, new TreeMap<>());
            }

            if(!mp.get(vertical).containsKey(level)){
                mp.get(vertical).put(level, new PriorityQueue<>());
            }

            mp.get(vertical).get(level).add(node.val);

            if(node.left != null){
                q.add(new Tuple(node.left, vertical - 1, level + 1));
            }

            if(node.right != null){
                q.add(new Tuple(node.right, vertical + 1, level + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> tm : mp.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : tm.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}