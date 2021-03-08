// Recursion

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        if(root.val > val)
            root.left =  insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        
        return root;
    }
}

// Iterative

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        
        TreeNode current = root;
        TreeNode parent = null;
        
        while(current != null){
            parent = current;
            if(val > current.val)
                current = current.right;
            else
                current = current.left;
        }
        
        if(val > parent.val)
            parent.right = new TreeNode(val);
        else
            parent.left = new TreeNode(val);
        
        return root;
    }
}