class Solution {
    public Node flatten(Node head) {
        Node p = head;
        
        while(p != null){
            if(p.child != null){
                Node right = p.next;
                
                p.next = flatten(p.child);
                p.next.prev = p;
                p.child = null;
                
                while(p.next != null)
                    p = p.next;
                
                if(right != null){
                    p.next = right;
                    p.next.prev = p;
                }
            }
            p = p.next;
        }
        
        return head;
    }
}