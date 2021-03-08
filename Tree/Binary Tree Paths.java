// Recursive

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root != null) helper(root, "", res);
        return res;
    }
    
    private static void helper(TreeNode root, String str, List<String> res){
        if(root.left == null && root.right == null)
            res.add(str + root.val);
        if(root.left != null)
            helper(root.left, str + root.val + "->", res);
        if(root.right != null)
            helper(root.right, str + root.val +  "->", res);
    }
}

// Iterative

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<String> queueStr = new LinkedList<>();
        
        queueNode.add(root);
        queueStr.add("");
        
        while(!queueNode.isEmpty()){
            TreeNode currentNode = queueNode.poll();
            String currentStr = queueStr.poll();
            
            if(currentNode.left == null && currentNode.right == null)
                res.add(currentStr + currentNode.val);
            
            
            if(currentNode.left != null){
                queueNode.add(currentNode.left);
                queueStr.add(currentStr + currentNode.val + "->");
            }
            
            if(currentNode.right != null){
                queueNode.add(currentNode.right);
                queueStr.add(currentStr + currentNode.val + "->");
            }
        }
        
        return res;
    }
}