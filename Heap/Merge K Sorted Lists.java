// Brute Force

// Time Complexity - O(NLogN)
// Space Complexity - O(N)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        List<Integer> arrayList = new ArrayList<>();
        
        for(ListNode list : lists){
            while(list != null){
                arrayList.add(list.val);
                list = list.next;
            }
        }
        
        Collections.sort(arrayList);
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        for(int num : arrayList){
            ListNode node = new ListNode(num);
            temp.next = node;
            temp = temp.next;
        }
        
        temp.next = null;
        return dummy.next;
    }
}

// Using Heap

// Time Complexity - O(NLogK)
// Space Complexity - O(N)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
    
        
        for(ListNode list : lists){
            if(list != null){
                minHeap.offer(list);
            }
        }
        
        while(!minHeap.isEmpty()){
            temp.next = minHeap.poll();
            temp = temp.next;
            
            if(temp.next != null)
                minHeap.offer(temp.next);
        }
        
        return dummy.next;
    }
}