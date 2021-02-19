// Using Recursion

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode right = root.right;
        TreeNode left = root.left;
        
        root.left = invertTree(right);
        root.right = invertTree(left);
        
        return root;
    }
}

// Iterative

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        
        return root;
    }
}