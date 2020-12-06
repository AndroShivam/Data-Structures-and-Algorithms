class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]
        );
        
        int[] result = new int[k];
        
        for(int i=0; i<mat.length; i++){
            pq.offer(new int[] {numOnes(mat[i]), i});
            
            if(pq.size() > k)
                pq.poll();
        }
        
        while(k > 0)
            result[--k] = pq.poll()[1];
        
        return result;
    }
    
    private int numOnes(int[] row){
        int low = 0;
        int high = row.length;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(row[mid] == 1)
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }
}