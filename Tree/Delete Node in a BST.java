class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{ // found key
            if(root.left == null && root.right == null){ // Case 1 : No children
                root = null;
                return root;
            }else if(root.right == null) // Case 2 : One Children
                return root.left;
            else if(root.left == null)
                return root.right;
            else{ // Case 3 : Two Children
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode root){
        while(root.left != null)
            root = root.left;
        return root;
    }
}