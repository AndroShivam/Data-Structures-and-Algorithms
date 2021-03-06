class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            if(current.left == null && current.right != null){
                result.add(current.right.data);
            }
            
            if(current.left != null && current.right == null){
                result.add(current.left.data);
            }
            
            if(current.left != null){
                queue.offer(current.left);
            }
            
            if(current.right != null){
                queue.offer(current.right);
            }
        }
        
        Collections.sort(result);
        
        if(result.isEmpty()){
            result.add(-1);
        }
        
        return result;
    }
}