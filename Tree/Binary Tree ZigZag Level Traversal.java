class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = null;
        
        if(root == null) return res;
         
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean zigzag = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            row = new ArrayList<>();
            for(int i=1; i<=size; i++){
                TreeNode current = queue.poll();
                
                if(zigzag){
                    row.add(0,current.val);
                }else{
                    row.add(current.val);
                }
                
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            res.add(row);
            zigzag = !zigzag;
        }
        
        return res;
    }
}