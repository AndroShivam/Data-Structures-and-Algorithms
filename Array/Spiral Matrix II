class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int i=colStart; i<=colEnd; i++){ // left to right
                res[rowStart][i] = num++;
            }
            rowStart++;
            
            for(int i=rowStart; i<=rowEnd; i++){ // top to bottom
                res[i][colEnd] = num++;
            }
            colEnd--;
            
            for(int i=colEnd; i>=colStart; i--){ // right to left
                res[rowEnd][i] = num++;
            }
            rowEnd--;
            
            for(int i=rowEnd; i>=rowStart; i--){ // bottom to top
                res[i][colStart] = num++;
            }
            colStart++;
        }
        
        return res;
        
    }
}
