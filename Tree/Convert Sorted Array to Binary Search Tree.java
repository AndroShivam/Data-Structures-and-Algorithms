class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int low, int high){
        if(low > high)
            return null;
        
        int mid = low + (high - low)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = helper(nums, low, mid - 1);
        root.right = helper(nums, mid + 1, high);
        
        return root;
    }
}