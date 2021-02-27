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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        
        ListNode dummy = new ListNode(head.val == 0 ? 1 : 0); // to guarantee the dummy node is not same as the original head. 
        
        dummy.next = head;
        
        ListNode current = head;
        ListNode pre = dummy;
        ListNode temp = dummy; // contains distinct elements
        
        while(current != null && current.next != null){ 
            if(current.val != pre.val && current.val != current.next.val){ // we found a unique node, we connect it to the temp list
                temp.next = current;
                temp = temp.next;
            }
            pre = current;
            current = current.next;
        }
        
        if(pre.val != current.val){  // the last node needs to be dealt with independently
            temp.next = current;
            temp = temp.next;
        }
        
        temp.next = null;
        
        return dummy.next;
    }
}