// BFS

// Time Complexity - O(V + E)
// Space Complexity - O(N)

class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for(int i=0; i<len; i++){ // because there can be multiple components in a graph
            if(colors[i] != 0) continue; // already visited
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1; // blue = 1, red = -1;
            
            while(!queue.isEmpty()){
                int current = queue.poll();
                for(int next : graph[current]){
                    if(colors[next] == 0){ // not visited, mark with different color
                        colors[next] = -colors[current];
                        queue.offer(next);
                    }else if(colors[next] != -colors[current]) // adjacent colors are not different, hence not bipartite
                        return false;
                }  
            }
        }
        
        return true;
    }
}