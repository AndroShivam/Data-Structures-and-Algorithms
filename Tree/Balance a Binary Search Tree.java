/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Time Complexity - O(N)
// Space Complexity - O(N)


class Solution {
    List<TreeNode> inorder = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return sortedArrayToBST(0, inorder.size() - 1);
    }
    
    private void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            inorder.add(root);
            inorder(root.right);
        }
    }
    
    private TreeNode sortedArrayToBST(int low, int high){
        if(low > high) return null;
        
        int mid = low + (high - low)/2;
        TreeNode node = inorder.get(mid);
        
        node.left = sortedArrayToBST(low, mid - 1);
        node.right = sortedArrayToBST(mid + 1, high);
        
        return node;
    }
    
}