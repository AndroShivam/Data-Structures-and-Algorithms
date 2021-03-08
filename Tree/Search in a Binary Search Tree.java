// Recursive

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;
        
        if(val > root.val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }
}

// Iterative

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        
        TreeNode current = root;
        
        while(current != null){
            if(current.val == val)
                return current;
            else if(current.val < val)
                current = current.right;
            else
                current = current.left;
        }
        
        return current;
    }
}