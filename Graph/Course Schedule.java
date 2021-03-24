class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        
        for(int i=0; i<numCourses; i++)
            list.add(new LinkedList<>());
        
        for(int[] pair : prerequisites){
            inDegree[pair[0]]++;
            list.get(pair[1]).add(pair[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            numCourses--;
            for(int neighbor : list.get(current)){
                if(--inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        
        return numCourses == 0;
    }
}

// Solution 1 : Find cycle in the graph
// Solution 2 : topological sort (if indegree does not become 0 for all in the end means there exist cycle)