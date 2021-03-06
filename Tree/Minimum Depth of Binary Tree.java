class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                TreeNode current = queue.poll();
                
                if(current.left == null && current.right == null)
                    return level;
                
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            level++;
        }
        
        return level;
    }
}

// in BFS first node with 0 children would be the minimum depth