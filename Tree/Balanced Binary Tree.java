// Approach 2

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int leftSubtreeHeight = findHeight(root.left);
        int rightSubtreeHeight = findHeight(root.right);
        
        return Math.abs(leftSubtreeHeight - rightSubtreeHeight) <=1
            && isBalanced(root.left)
            && isBalanced(root.right);
    }
    
    private int findHeight(TreeNode root){
        if(root == null)
            return 0;
        
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        
        return Math.max(left, right) + 1;
    }
    
}

// Approach 2

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        return helper(root) != -1;
    }
    
    private int helper(TreeNode root){
        if(root == null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        
        return Math.max(left, right) + 1;
    }
}