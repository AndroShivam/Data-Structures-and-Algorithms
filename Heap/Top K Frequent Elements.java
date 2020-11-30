class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        for(int i=0; i<k; i++){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            result[i] = entry.getKey();
        }
        
        return result;
    }
}