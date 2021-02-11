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
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        dummy.next = head;
        
        while(current.next != null && current.next.next != null){
            ListNode swap1 = current.next;
            ListNode swap2 = current.next.next;
            current.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            current = swap1;
        }
        
        return dummy.next;
        
        
    }
}


/*

 node = 1 -> 2 -> 3 -> 4
 dummy =    0    ->  1    ->  2   -> 3 -> 4
         current   swap1    swap2

current.next = swap2       0 -> 2
swap1.next = swap2.next    1 -> 3
swap2.next = swap1         0 -> 2 -> 1 -> 3

0       ->  2    ->  1   -> 3
current    swap2   swap1
 
current = swap1

current = 1

*/