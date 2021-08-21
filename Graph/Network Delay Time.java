class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        pq.add(new int[]{0, k});
        int res = 0;
        
        boolean[] visited = new boolean[n + 1];
        
        while(!pq.isEmpty()){
            int[] current = pq.remove();
            int currentDistance = current[0];
            int currentNode = current[1];
            if(visited[currentNode]) continue;
            visited[currentNode] = true;    
            res = currentDistance;
            n--;
            if(n == 0) return res;
            if(map.containsKey(currentNode)){
                for(int next : map.get(currentNode).keySet()){
                    pq.offer(new int[]{currentDistance + map.get(currentNode).get(next), next});
                }
            }
        }
        
        return -1;
    }
}