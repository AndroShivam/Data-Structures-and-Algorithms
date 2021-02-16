// Time Complexity - O(N^2)
// Space Complexity - O(N + M)

class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i=0; i<row.length; i++){
            if(row[i]){
                nullifyRow(matrix, i);
            }
        }
        
        for(int i=0; i<col.length; i++){
            if(col[i]){
                nullifyCol(matrix, i);
            }
        }
    }
    
    private void nullifyRow(int[][] matrix, int row){
        for(int i=0; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }
    
    
    private void nullifyCol(int[][] matrix, int col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean rowHasZero = false;
        boolean colHasZero = false;
        
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowHasZero = true;
                break;
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                colHasZero = true;
                break;
            }
        }
        
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                nullifyRow(matrix, i);
            }
        }
        
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                nullifyCol(matrix, j);
            }
        }
        
        if(rowHasZero) nullifyRow(matrix, 0);
        if(colHasZero) nullifyCol(matrix, 0);
    }
    
     private void nullifyRow(int[][] matrix, int row){
        for(int i=0; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }
    
    
    private void nullifyCol(int[][] matrix, int col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
}