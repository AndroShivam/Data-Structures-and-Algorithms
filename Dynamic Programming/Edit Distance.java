// Recursive

// Time Complexity - O(3^m) // if none of the characters of two string match


class Solution {
    public int minDistance(String word1, String word2) {
        return findMinDistance(word1, word2, word1.length(), word2.length());
    }
    
    private int findMinDistance(String word1, String word2, int m, int n){
        if(m == 0) return n;
        if(n == 0) return m;
        
        if(word1.charAt(m - 1) == word2.charAt(n - 1))
            return findMinDistance(word1, word2, m - 1, n - 1);
        
        int insert = findMinDistance(word1, word2, m, n - 1);
        int delete = findMinDistance(word1, word2, m - 1, n);
        int replace = findMinDistance(word1, word2, m - 1, n - 1);
        
        return 1 + Math.min(Math.min(insert, delete), replace);
    }
    
}

// Dynamic Programming

// Time Complexity - O(M*N) 

class Solution {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i=0; i<=m; i++)
            dp[i][0] = i;
        
        for(int j=0; j<=n; j++)
            dp[0][j] = j;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1]; // no operations
                else
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
            }
        }
        
        return dp[m][n];
    }
    
    private int min(int a, int b, int c){
        int smallest = a;
        if(smallest > b) smallest = b;
        if(smallest > c) smallest = c;
        return smallest;
    }
}