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
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }
    
    private void traverse(TreeNode root, List<List<Integer>> result, int level){
        if(root == null) 
            return;
        
        if(result.size() <= level){
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }
        
        List<Integer> collection = result.get(level);
        if(level % 2 == 0)
            collection.add(root.val);
        else
            collection.add(0, root.val);
        
        traverse(root.left, result, level + 1);
        traverse(root.right, result, level + 1);
    }
}
