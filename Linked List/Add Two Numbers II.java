// By Reversing Linked Lists

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode list1 = reverse(l1);
        ListNode list2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
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
        
        dummy = dummy.next;
        
        return reverse(dummy);
    }
    
    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null, next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}


// Using Stacks

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        
        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        
        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        
        ListNode dummy = null;
        int carry = 0;
        
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            
            int first = stack1.isEmpty() ? 0 : stack1.pop().val;
            int second = stack2.isEmpty() ? 0 : stack2.pop().val;
            
            int sum = first + second + carry;
            
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = dummy;
            dummy = newNode;
            
            carry = sum / 10;
        }
        
        return dummy;
    }
}