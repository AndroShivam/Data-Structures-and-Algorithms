class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        
        String s1 = s;
        String s2 = reverse(s);
        
        int m = s1.length();
        int n = s2.length();
        
        dp = new int[m + 1][n + 1];
        
        for(int[] cell : dp)
            Arrays.fill(cell, -1);
        
        return findLCS(s1, s2, m, n);
    }
    
    private int findLCS(String s1, String s2, int m, int n){
        if(m == 0 || n == 0) return 0;
        
        if(dp[m][n] != -1) return dp[m][n];
        
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = 1 + findLCS(s1, s2, m - 1, n - 1);
        
        return dp[m][n] = Math.max(findLCS(s1, s2, m - 1, n), findLCS(s1, s2, m, n - 1));
    }
    
    private String reverse(String s){
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }
}