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