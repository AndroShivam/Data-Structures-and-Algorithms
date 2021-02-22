// Time Complexity - O(N + M)
// Space Complexity - O(N + M)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        ListNode list1 = l1;
        ListNode list2 = l2;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        if(list1 == null)
            current.next = list2;
        else
            current.next = list1;
        
        
        return dummy.next;
        
    }
}

// Time Complexity - O(N + M)
// Space Complexity - O(1)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        // make sure l1 is the smaller list
        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        ListNode result = l1;
        
        while(l1 != null && l2 != null){
            ListNode current = null;
            while(l1 != null && l1.val <= l2.val){
                current = l1;
                l1 = l1.next;
            }
            
            current.next = l2;
            
            ListNode temp = l1; // swap
            l1 = l2;
            l2 = temp;
        }
        
        return result;
        
    }
}