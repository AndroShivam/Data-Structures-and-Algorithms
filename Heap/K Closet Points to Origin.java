class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] left, int[] right){
                return getDistance(right) - getDistance(left);
            }
        });
        
        for(int[] point : points){
            heap.add(point);
            
            if(heap.size() > K)
                heap.poll();
        }
        
        int[][] result = new int[K][2]; // we have to return k arrays of size 2 each
        
        while(K > 0){
            result[--K] = heap.poll();
        }
        
        return result;
    }
    
    private int getDistance(int[] point){
        return point[0] * point[0] + point[1] * point[1]; // sqrt((x - x1)^2 + (y - y1)^2) in this case x1 and y1 are 0 (origin)
    }
}