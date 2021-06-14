// Time Complexity - O(M^2 x N^2)
// Space Complexity - O(1)

class Solution {
    public int numSubmat(int[][] mat) {
        
        int row = mat.length;
        int col = mat[0].length;
        int count = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                count += helper(mat, i, j);
            }
        }
        
        return count;
    }
    
    private int helper(int[][] mat, int x, int y){
        
        int row = mat.length;
        int col = mat[0].length;
        int count = 0;
        int bound = col;
        
        for(int i=x; i<row; i++){
            for(int j=y; j<bound; j++){
                if(mat[i][j] == 1)
                    count++;
                else
                    bound = j;
            }
        }
        return count;
    }
}