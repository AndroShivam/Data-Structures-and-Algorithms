// Time Complexity - O(N)
// Space Complexity - O(height)

class Solution {
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            
            if(first == null && (prev == null || prev.val >= root.val))
                first = prev;
            
            if(first != null && prev.val >= root.val)
                second = root;
            
            prev = root;
            inorder(root.right);
        }
    }
}