// Using HashMap

// Time Complexity - O(N^2)
// Space Complexity - O(N^2) // in worst case there will be n^2 key-value pairs

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                int sum = -1 *(C[i] + D[j]);
                
                count += map.getOrDefault(sum, 0);
            }
        }
        
        return count;
    }
}