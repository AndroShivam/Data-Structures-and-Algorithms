// Recursive

// Time Complexity - O(2^N)
// Space Complexity - O(N)

class Solution {
    public int minPathSum(int[][] grid) {
        return min(grid, grid.length - 1, grid[0].length - 1);
    }
    
    private int min(int[][] grid, int row, int col){
        if(row == 0 && col == 0) return grid[row][col];
        
        if(row == 0) return grid[row][col] + min(grid, row, col - 1);
        if(col == 0) return grid[row][col] + min(grid, row - 1, col);
        
        return grid[row][col] + Math.min(min(grid, row - 1, col), min(grid, row, col - 1));
    }
}

// Dynamic Programming

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)

class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] minSum = new int[row][col];
        minSum[0][0] = grid[0][0];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(i == 0 && j > 0) minSum[i][j] = grid[i][j] + minSum[i][j - 1];
                else if(j == 0 && i > 0) minSum[i][j] = grid[i][j] + minSum[i - 1][j];
                else if(i > 0 &&  j > 0) minSum[i][j] = grid[i][j] + Math.min(minSum[i - 1][j], minSum[i][j - 1]);
            }
        }
        
        return minSum[row - 1][col - 1];
    }
}

// Dynamic Programming

// Time Complexity - O(N^2)
// Space Complexity - O(N)

class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[] minSum = new int[col];
        minSum[0] = grid[0][0];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(i == 0 && j > 0) minSum[j] = minSum[j - 1] + grid[i][j];
                else if(j == 0 && i > 0) minSum[j] = minSum[j] + grid[i][j];
                else if(i > 0 && j > 0) minSum[j] = Math.min(minSum[j - 1], minSum[j]) + grid[i][j];
            }
        }
        
        return minSum[col - 1];
    }
}