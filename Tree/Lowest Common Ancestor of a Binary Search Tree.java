// Recursive

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}

// Iterative

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     
        int pVal = p.val;
        int qVal = q.val;
        TreeNode current = root;
        
        while(current != null){
            int parentVal = current.val;
            
            if(pVal > parentVal && qVal > parentVal)
                current = current.right;
            else if(pVal < parentVal && qVal < parentVal)
                current = current.left;
            else
                return current;
        }
        
        return null;
    }
}