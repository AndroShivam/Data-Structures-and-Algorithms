// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for(ListNode current = head; current != null; current = current.next)
            list.add(current.val);
        
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<list.size(); i++){
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
                res[stack.pop()] = list.get(i);
            stack.push(i);
        }
        
        return res;
    }
}