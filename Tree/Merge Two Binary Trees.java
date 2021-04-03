// Recursive

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        
        return newNode;
    }
}

// Iterative

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        Stack<TreeNode[]> stack = new Stack<>();
        
        stack.push(new TreeNode[]{root1, root2});
        
        while(!stack.isEmpty()){
            TreeNode[] current = stack.pop();
            
            if(current[0] == null || current[1] == null) continue;
            
            current[0].val += current[1].val;
            
            if(current[0].left == null){
                current[0].left = current[1].left;
            }else{
                stack.push(new TreeNode[]{current[0].left, current[1].left});
            }
            
            if(current[0].right == null){
                current[0].right = current[1].right;
            }else{
                stack.push(new TreeNode[]{current[0].right, current[1].right});
            }
        }
        
        return root1;
    }
}