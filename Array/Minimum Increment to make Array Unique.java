class Solution {
    public int minIncrementForUnique(int[] A) {
        if(A == null || A.length == 0) return 0;
        
        Arrays.sort(A);
        
        int result = 0, prev = A[0];
        
        for(int i=1; i<A.length; i++){
            int expected = prev + 1;
            result += A[i] >= expected ? 0 : expected - A[i];
            prev = Math.max(expected, A[i]);
        }
        
        return result;
    }
}