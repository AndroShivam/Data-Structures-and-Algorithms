class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];
        
        for(int cell[] : dp)
            Arrays.fill(cell, -1);
        
        return findLCS(text1, text2, text1.length(), text2.length());
    }
    
    private int findLCS(String s1, String s2, int m, int n){
        if(m == 0 || n == 0) return 0;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = findLCS(s1, s2, m - 1, n - 1) + 1;
        
        return dp[m][n] = Math.max(findLCS(s1,s2,m-1,n), findLCS(s1,s2,m,n-1));
    }
}