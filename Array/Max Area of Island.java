// Time Complexity - O(N*M)
// Space Complexity - O(N*M)

class Solution {
    int row, col;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int currentArea = dfs(grid, visited, i, j);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || grid[i][j] == 0) return 0;
        
        visited[i][j] = true;
        
        return 1 + dfs(grid, visited, i - 1, j) 
                 + dfs(grid, visited, i + 1, j)
                 + dfs(grid, visited, i, j - 1)
                 + dfs(grid, visited, i, j + 1);
    }
}