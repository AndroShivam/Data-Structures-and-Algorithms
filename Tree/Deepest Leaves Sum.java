class Solution {
    public int deepestLeavesSum(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int sum = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                sum += current.val;
                
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }
        
        return sum;
    }
}