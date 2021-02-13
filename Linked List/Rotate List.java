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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null) return head;
        
        ListNode current = head;
        int len = 1;
        
        while(current.next != null){ // traverse to the end of the list
            len++;
            current = current.next;
        }
        
        current.next = head; // connect last node with first node to form a circular link
        k = k % len; // a list rotated twice becomes original again hence k % len will give exact number of rotations
        k = len - k; // to reach the head of rotated list
        
        while(k > 0){ // traverse to the last node of the rotated list
            current = current.next;
            k--;
        }
        
        head = current.next; // change head
        current.next = null; // disconnect last node from first node
        
        return head;
    }
}