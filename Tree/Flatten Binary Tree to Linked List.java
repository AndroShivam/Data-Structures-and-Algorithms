// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode current = null, pre = null;
        
        while(!stack.isEmpty()){
            current = stack.pop();
            if(pre != null){
                pre.right = current;
                pre.left = null;
            }
            
            if(current.right != null) stack.push(current.right);
            if(current.left != null) stack.push(current.left);
            pre = current;
        }
        
        current.right = null;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}