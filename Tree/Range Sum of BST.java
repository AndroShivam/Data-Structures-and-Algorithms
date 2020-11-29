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
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null)
            return 0;
        
        if(root.val < low)  // left subtree excluded
            return rangeSumBST(root.right, low, high); 
        if(root.val > high) // right subtree excluded
            return rangeSumBST(root.left, low , high);
        
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}


// Iterative Solution

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                 if(node.val >= low && node.val <= high)
                result += node.val;
            
            if(node.val > low)
                stack.push(node.left);
            if(node.val < high)
                stack.push(node.right);
            }
        }
        
    return result;

    }
}