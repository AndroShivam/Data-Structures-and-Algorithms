class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result);
        return result;
    }
    
    private static void rightView(TreeNode current, int currentDepth, List<Integer> result){
        if(current == null)return;
        
        if(currentDepth == result.size())
            result.add(current.val);
        
        rightView(current.right, currentDepth + 1, result);
        rightView(current.left, currentDepth + 1, result);
    }
}