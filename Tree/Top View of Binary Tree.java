
/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class View
{
    // function should print the topView of the binary tree
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        class QueueObj{
            int hd;
            Node node;
            
            public QueueObj(Node node, int hd){
                this.hd = hd;
                this.node = node;
            }
        }
        
        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();  // TreeMap stores key value pair sorted on key value 
        
        queue.offer(new QueueObj(root, 0));
        
        while(!queue.isEmpty()){
            QueueObj current = queue.poll();
            
            if(!map.containsKey(current.hd)){
                map.put(current.hd, current.node);
            }
            
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