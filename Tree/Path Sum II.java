// Recursive

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, result, new ArrayList<>(), targetSum);
        return result;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> list, int target){
        if(root == null) return;
        list.add(root.val);
        
        if(root.left == null && root.right == null && target - root.val == 0)
            result.add(new ArrayList<>(list));
        
        dfs(root.left, result, list, target - root.val);
        dfs(root.right, result, list, target - root.val);
        list.remove(list.size() - 1);
    }
}