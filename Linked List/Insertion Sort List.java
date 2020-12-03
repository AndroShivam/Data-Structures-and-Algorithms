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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy; // prev to traverse the sorted list
        ListNode current = head; // points to current node in the unsorted list
        ListNode next; // so that we always have link to next node
        
        while(current != null){
            next = current.next;
            
            while(prev.next != null && prev.next.val < current.val)
                prev = prev.next; // to get to the index where our element should be inserted
            
            
            current.next = prev.next;
            prev.next = current;
            
            prev = dummy; // move back prev to dummy (so we can traverse again)
            current = next;
        }
        
        return dummy.next;
    }
}