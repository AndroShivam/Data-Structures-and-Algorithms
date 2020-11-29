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

// Recursive Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return left == right;
        
        if(left.val != right.val)
            return false;
        
        return isSymmetricHelper(left.left, right.right)
            && isSymmetricHelper(left.right, right.left);
    }
}

// Iterative Solution 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
    
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.isEmpty()){
            TreeNode s1 = stack.pop();
            TreeNode s2 = stack.pop();
            
            if(s1 == null && s2 == null)
                continue;
            
            if(s1 == null || s2 == null || s1.val != s2.val)
                return false;
            
            stack.push(s1.left);
            stack.push(s2.right);
            stack.push(s1.right);
            stack.push(s2.left);
        }
        
        return true;
    }
}