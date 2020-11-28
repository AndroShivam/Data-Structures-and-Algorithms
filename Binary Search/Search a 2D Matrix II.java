class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
           return false;
        }
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row <= matrix.length - 1 && col >= 0){
            if(target == matrix[row][col])
                return true;
            else if(target < matrix[row][col]) // whole column would be greater than the target 
                col--; // so move to previous column
            else if(target > matrix[row][col]) // matrix[row][col] is smaller than target as its sorted means there is a chance of finding the element in the downward direction so row++
                row++;
        }
        
        return false;
    }
}