// Time Complexity - O(NlogN)
// Space Complexity - O(N)

class Solution {
    public int lastStoneWeight(int[] stones) {
     
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone : stones)
            maxHeap.offer(stone);
        
        while(maxHeap.size() >= 2){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            
            maxHeap.offer(y - x);
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}