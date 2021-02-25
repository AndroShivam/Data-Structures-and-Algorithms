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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        
        for(int i=0; i<left - 1; i++)
            pre = pre.next;
        
        ListNode current = pre.next;
        ListNode nxt = pre.next.next;
        
        for(int i=0; i<right-left; i++){
            current.next = nxt.next;
            nxt.next = pre.next;
            pre.next = nxt;
            nxt = current.next;
        }
        
        return dummy.next;
        
    }
}

// An animated GIF to get better understanding
// https://static.pythonical.org/ReverseSublist1.gif