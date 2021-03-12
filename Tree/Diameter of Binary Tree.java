// Time Complexity - O(N^2)

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int depth = depth(root.left) + depth(root.right);
        
        int diaLeft = diameterOfBinaryTree(root.left);
        int diaRight = diameterOfBinaryTree(root.right);
        
        return Math.max(depth, Math.max(diaLeft, diaRight));
    }
    
    private int depth(TreeNode root){
        if(root == null) return 0;
        
        int leftSubtree = depth(root.left);
        int rightSubtree = depth(root.right);
        
        return Math.max(leftSubtree, rightSubtree) + 1;
    }
}


// Time Complexity - O(N)

class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    
    private int longestPath(TreeNode root){
        if(root == null) return 0;
        
        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);
        
        diameter = Math.max(diameter, leftPath + rightPath);
        
        return Math.max(leftPath, rightPath) + 1;
    }
    
}