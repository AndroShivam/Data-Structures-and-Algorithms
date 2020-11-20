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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode result = null;
        
        if(l1.val > l2.val){
            result = l2;
            l2 = l2.next;
        }else{
            result = l1;
            l1 = l1.next;
        }
        
        ListNode currentNode = result;
        
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                currentNode.next = l2;
                l2 = l2.next;
            }else{
                currentNode.next = l1;
                l1 = l1.next;
            }
            
            currentNode = currentNode.next;
        }
        
        
        currentNode.next = (l1 == null) ? l2 : l1;
        
        return result;
    }
}