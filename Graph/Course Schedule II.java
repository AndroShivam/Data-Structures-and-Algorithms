class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());
        
        for(int[] pair : prerequisites){
            inDegree[pair[0]]++;
            adj.get(pair[1]).add(pair[0]);
        }
        
        int index = 0;
        
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                res[index++] = i;
            }
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int neighbor : adj.get(current)){
                if(--inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                    res[index++] = neighbor;
                }
            }
        }
        
        return index == numCourses ? res : new int[0];
    }
}