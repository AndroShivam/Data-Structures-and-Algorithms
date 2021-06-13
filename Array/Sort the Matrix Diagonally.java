Time Complexity - O(MNlogD), where D is the length of diagonal with D = min(M,N).
Space Complexity - O(MN)

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).add(mat[i][j]);
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                mat[i][j] = map.get(i - j).poll();
            }
        }
        
        return mat;
    }
}