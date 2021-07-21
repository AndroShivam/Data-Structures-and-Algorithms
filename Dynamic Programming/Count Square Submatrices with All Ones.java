// Time Complexity - O(N*M)
// Space Complexity - O(1)

class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int result = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        result += 1;
                    }else{
                        int cellVal = min(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i][j - 1]) + matrix[i][j];
                        result += cellVal;
                        matrix[i][j] = cellVal;
                    }
                }
            }
        }
        
        return result;
    }
    
    private int min(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
}

// Explanation -https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
// Credits to @arkaung on leetcode.com