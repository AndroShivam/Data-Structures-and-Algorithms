// Time Complexity - We will have to visit every node once so O(N);
// Space Complexity - O(H)

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        
 	// If the value of this node is less than L, then the whole left subtree will be smaller, 
        // so we can discard the left sub tree and return the root of the trimmed right sub tree 
        if(root.val < low) 
            return trimBST(root.right, low, high);
        
  	// If the value of this node is greater than R, then the whole right subtree will be greater
        // so we can discard the right sub tree and return the root of the trimmed left sub tree
        if(root.val > high)
            return trimBST(root.left, low, high);
        
 	// If the value of this node does not need to be deleted, 
        // we need to pass this recursive call downwards to both sides
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
 	// All the processing of the subtrees done, now return this node
        return root;
    }
}