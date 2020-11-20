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
    public boolean isPalindrome(ListNode head) {
        
  
        Stack<Integer> stack = new Stack<>();
        ListNode currentNode = head;
        
        while(currentNode != null){
            stack.add(currentNode.val);
            currentNode = currentNode.next;
        }
        
        currentNode = head;
        while(currentNode != null || !stack.isEmpty()){
            if(currentNode.val != stack.pop())
                return false;
            
            currentNode = currentNode.next;
        }
        
        return true;
    }
}