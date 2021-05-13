// Time Complexity = O(N * M)
// Space Complexity = O(N * M)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] cell : dp)
            Arrays.fill(cell, -1);
        
        return countPaths(obstacleGrid, 0, 0, m, n, dp);
    }
    
    private int countPaths(int[][] obstacleGrid, int i, int j, int m, int n, int[][] dp){
        if(i >= m || j >= n || obstacleGrid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1 && obstacleGrid[i][j] == 0) return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        return dp[i][j] = countPaths(obstacleGrid, i + 1, j, m, n, dp) + countPaths(obstacleGrid, i, j + 1, m, n, dp);
    }
}