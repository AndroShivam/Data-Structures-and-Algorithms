// Using Two Stacks

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        stack1.push(root);
        
        while(!stack1.isEmpty()){
            TreeNode current = stack1.pop();
            stack2.push(current);
            
            if(current.left != null) stack1.push(current.left);
            if(current.right != null) stack1.push(current.right);
        }
        
        while(!stack2.isEmpty())
            result.add(stack2.pop().val);
        
        return result;
    }
}

// Using One Stack

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeNode current = root;
        
        while(current != null || !stack.isEmpty()){
            while(!isLeaf(current)){
                stack.push(current);
                current = current.left;
            }
            
            if(current != null)
                result.add(current.val);
            
            // if current element is the right child of stack top then,
            // we know that have traversed left and right now we need to pop root
            while(!stack.isEmpty() && current == stack.peek().right) { 
                current = stack.pop();
                result.add(current.val);
            }
            
            if(stack.isEmpty())
                current = null;
            else
                current = stack.peek().right;
        }
        
        return result;
    }
    
    private boolean isLeaf(TreeNode curr){
        if(curr == null) return true;
        return curr.left == null && curr.right == null;
    }
}