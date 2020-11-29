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
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        int count = 0;
        
        while(!stack.isEmpty() || currentNode != null){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }else{
                TreeNode node = stack.pop();
                if(++count == k){
                    return node.val;
                }
                
                currentNode = node.right;
            }
        }
        
        return Integer.MIN_VALUE;
    }
}