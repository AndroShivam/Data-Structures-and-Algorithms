// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }       
        return false;
    }
}

// Time Complexity - O(N+M)
// Space Complexity - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int col = matrix[0].length - 1;
        int n = matrix.length;
        
        while(row < n && col >= 0){
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        
        return false;
    }
}

// Time Complexity - O(Log(MN))
// Space Complexity - O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) 
            return false;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int low = 0;
        int high = (n * m) - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(matrix[mid/m][mid%m] == target)
                return true;
            if(matrix[mid/m][mid%m] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return false;
    }
}