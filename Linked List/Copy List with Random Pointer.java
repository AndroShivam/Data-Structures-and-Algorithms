// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        
        // copy all nodes into map
        Node node = head;
        while(node != null){
            map.put(node, new Node(node.val));
            node = node.next;
        }
        
        // assign next and random pointers
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public Node copyRandomList(Node head) {
        Node itr = head, next;
        
        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while(itr != null){
            next = itr.next;
            
            Node copy = new Node(itr.val);
            itr.next = copy;
            copy.next = next;
            
            itr = next;
        }
        
        // Second round: assign random pointers for the copy nodes.
        itr = head;
        while(itr != null){
            if(itr.random != null){
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }
        
        // Third round: restore the original list, and extract the copy list.
        itr = head;
        Node dummyHead = new Node(0);
        Node copy, copyItr = dummyHead;
        
        while(itr != null){
            next = itr.next.next;
            
            // extract the copy
            copy = itr.next;
            copyItr.next = copy;
            copyItr = copy;
            
            // restore original list
            itr.next = next;
            
            itr = next;
        }
        
        return dummyHead.next;
    }
}