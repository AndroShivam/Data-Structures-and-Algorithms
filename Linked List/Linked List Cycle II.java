// Time Complexity - O(N)
// Space Complexity - O(N)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode current = head;
        
        while(current != null){
            if(map.containsKey(current))
                return current;
            
            map.put(current, current.val);
            current = current.next;
        }
        
        return null;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow == fast){
                fast = head;
                
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow;
            }
        }
        return null;
    }
}