// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }
    
    private TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail) return null;
        
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        
        return root;
    }
}