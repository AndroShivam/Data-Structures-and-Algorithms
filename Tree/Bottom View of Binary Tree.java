class Tree
{
 
    // Method that returns the bottom view.
    public ArrayList <Integer> bottomView(Node root)
    {
    // Code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        class QueueObj {
            int hd;
            Node node;
            public QueueObj(Node node, int hd){
                this.hd = hd;
                this.node = node;
            }
        }
        
        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        
        queue.offer(new QueueObj(root, 0));
        
        while(!queue.isEmpty()){
            QueueObj current = queue.poll();
            
            map.put(current.hd, current.node); // overide 
            
            if(current.node.left != null){
                queue.offer(new QueueObj(current.node.left, current.hd - 1));
            }
            
            if(current.node.right != null){
                queue.offer(new QueueObj(current.node.right, current.hd + 1));
            }
        }
        
        for(Map.Entry<Integer, Node> entry : map.entrySet()){
            res.add(entry.getValue().data);
        }
        return res;
    }
}