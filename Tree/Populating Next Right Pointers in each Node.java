// Recursive Solution

class Solution {
    public Node connect(Node root) {
        if(root == null || root.left == null)
            return root;
        
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}

// Iterative Solution

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Node pre = root;
        Node curr = null;
        
        while(pre.left != null){
            curr = pre;
            
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            pre = pre.left;
        }
        
        return root;
    }
}

// if next doesnot point to null initially

class Solution
{
    /*
    Node class is Defined as follows:
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
    */
    public void connect(Node root)
    {
        // Your code goes here.
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            if(current != null){
                current.nextRight = queue.peek();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }else if(!queue.isEmpty()){
                queue.offer(null);
            }
        }
    }
}