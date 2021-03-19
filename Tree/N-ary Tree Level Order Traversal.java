// Iterative

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> row;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            row = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                Node current = queue.poll();
                row.add(current.val);
                for(Node child : current.children)
                    queue.offer(child);
            }
            result.add(row);
        }
        
        return result;
    }
}