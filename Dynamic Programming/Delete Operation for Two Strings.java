// Recursion with memoisation
// Time Complexity - O(M*N)

class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        dp = new int[m + 1][n + 1];
        for(int[] cell : dp) Arrays.fill(cell, -1);
        
        return m + n - 2 * lcs(word1, word2, m, n);
    }
    
    private int lcs(String s1, String s2, int m, int n){
        if(m == 0 || n == 0) return 0;
        
        if(dp[m][n] != -1) return dp[m][n];
        
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
        
        return dp[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    }
}

// Dynamic Programming
// Time Complexity - O(M*N)

class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i == 0 || j == 0) continue;
                
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return m + n - 2 * dp[m][n];
    }
}