// Recursive 

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBSTUtil(TreeNode root, long min, long max){
        if(root == null) return true;
        
        return root.val > min && root.val < max
            && isValidBSTUtil(root.left, min, root.val)
            && isValidBSTUtil(root.right, root.val, max);
    }
}

// Iterative (Inorder Traversal)

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            
            if(pre != null && pre.val >= current.val)
                return false;
            
            pre = current;
            current = current.right;
        }
        return true;
    }
}