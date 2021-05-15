// Reversing Preorder Traversal (not recommended)
// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack  = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(0, current.val);
            
            if(current.left != null) stack.push(current.left);
            if(current.right != null) stack.push(current.right);
        }
        
        return result;
    }
}

// Without Reversing Preorder Traversal
// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.peek();
            
            if(root.right != null){
                root = root.right;
            }else{
                root = stack.pop();
                result.add(root.val);
                
                while(!stack.isEmpty() && root == stack.peek().right){
                    root = stack.pop();
                    result.add(root.val);
                }
                root = null;
            }
        }
        
        return result;
    }
}