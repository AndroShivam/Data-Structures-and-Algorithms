// Time Complexity - O(N)
// Space Complexity - O(N)

public class Solution {
    public boolean hasCycle(ListNode head) {
     
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        
        while(current != null){
            if(list.contains(current))
                return true;
            
            list.add(current);
            current = current.next;
        }
        
        return false;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}