// Recursive

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null && (targetSum - root.val) == 0)
            return true;
        
        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }
}

// Iterative

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        
        stack.push(root);
        sumStack.push(targetSum);
        
        while(!stack.isEmpty() && root != null){
            TreeNode current = stack.pop();
            int currentVal = sumStack.pop();
            
            if(current.left == null && current.right == null && current.val == currentVal)
                return true;
            
            if(current.right != null){
                stack.push(current.right);
                sumStack.push(currentVal - current.val);
            }
            
            if(current.left != null){
                stack.push(current.left);
                sumStack.push(currentVal - current.val);
            }
        }
        
        return false;
    }
}