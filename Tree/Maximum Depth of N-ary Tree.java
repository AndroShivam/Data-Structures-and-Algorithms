// DFS

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int maxDepth = 0;
        for(Node child : root.children)
            maxDepth = Math.max(maxDepth, maxDepth(child));
        
        return maxDepth + 1;
    }
}

// BFS

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        int depth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                Node current = queue.poll();
                for(Node child : current.children)
                    queue.offer(child);
            }
            depth++;
        }
        
        return depth;
    }
}