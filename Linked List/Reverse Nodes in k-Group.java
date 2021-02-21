class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        
        int i = 0;
        
        while(head != null){
            i++;
            if(i % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        
        return dummy.next;
    }
    
    
    private ListNode reverse(ListNode begin, ListNode end){
        ListNode current = begin.next;
        ListNode prev = begin, next = null;
        ListNode first = current;
        
        while(current != end){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        begin.next = prev;
        first.next = current;
        
        return first;
    }
}

/*

100  200  300  400  500  600
-1 -> 1 -> 2 -> 3 -> 4 -> 5

k = 2

begin = rev(100, 400)

current = 200
prev = 100
first = 200

while(current != end) // 200 != 400

next = 300
current.next = 100
prev = 200
current = 300

         current
100  200  300  400  500  600
-1 <- 1    2 -> 3 -> 4 -> 5

while(current != end) // 300 != 400

next = 400
current.next = 200
prev = 300
current = 400

              current
100  200  300  400  500  600
-1 <- 1 <- 2   3 -> 4 -> 5

while(current != end) // 400 != 400 (false)

Actual representation of linked list

prev first begin    curr
300  200  100      400  500  600
2 -> 1 -> -1        3 -> 4 -> 5

begin.next = prev // 300

prev first begin    curr
300  200  100      400  500  600
2 -> 1 -> -1        3 -> 4 -> 5

begin prev first    curr
100  300    200     400  500  600  
-1 -> 2 ->  1       3 -> 4 -> 5


// connect the reversed linked list with remaining linked list

first.next = curr

begin prev first    curr
100  300    200     400  500  600  
-1 -> 2 ->  1   ->   3 -> 4 -> 5

return first // end of reversed linkedlist
 
*/