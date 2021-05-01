class Solution {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int maxLeftRight = Math.max(left, right);
        int maxWithRoot = Math.max(root.val, root.val + maxLeftRight);
        int maxWithRootLeftRight = Math.max(maxWithRoot, root.val + left + right);
        
        maxSum = Math.max(maxSum, maxWithRootLeftRight);
        
        return maxWithRoot;
    }
}

// Explanation
// https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/389609/Full-Explanation-article-with-pseudo-code-Beats-JAVA-100-time-and-100-space-Solution