// BFS

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        map.put(node, new Node(node.val));
        queue.offer(node);
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            for(Node neighbor : current.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}