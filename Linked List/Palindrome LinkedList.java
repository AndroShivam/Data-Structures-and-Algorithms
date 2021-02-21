// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public boolean isPalindrome(ListNode head) {
     Stack<Integer> stack = new Stack<>();
        Node slow = head;
        Node fast = head;

        // push elements till middle
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // in case of odd number of elements, skip middle
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
      }
}

// Time Complexity - O(N)
// Space Complexity - O(1)
// Note: this approach modifies original linkedlist

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast != null)
            slow = slow.next;
        
        slow = reverse(slow);
        fast = head;
        
        
        while(fast != null && slow != null){
            if(fast.val != slow.val)
                return false;
            
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    private static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;           
        }
        
        return prev;
    }
}