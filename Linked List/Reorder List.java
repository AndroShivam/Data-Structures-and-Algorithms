/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        // find middle of the linkedlist
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the second half
        
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        
        // link the two halves together 
        
        while(head != null &&  head2 != null){
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;
            
            head2.next = head.next;
            head.next = head2;
            
            head = temp1;
            head2 = temp2;
        }
        
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode next, prev = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}