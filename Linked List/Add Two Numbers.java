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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy; // to traverse dummy list
        int sum = 0;
        
        while(list1 != null || list2 != null){
            sum /= 10;
            
            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }
            
            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }
            
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        
        if(sum / 10 == 1){
            temp.next = new ListNode(1);
        }
        
        return dummy.next;
    }
}