class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        String res = null;
        int palindromeStartsAt = 0;
        int maxLen = 0;
        
        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
        boolean[][] dp = new boolean[n][n];
        
        for(int i=n-1; i>=0; i--){ // keep increasing the possible palindrome string
            for(int j=i; j<n; j++){  // find the max palindrome within this window of (i,j)
                
                // check if substring between (i,j) is palindrome
                // chars at i and j should match
                // if window is less than or equal to 3, just end chars should match
                // if window is > 3, substring (i+1, j-1) should be palindrome too
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i+1][j-1]);
                
                // update max palindrome string
                if(dp[i][j] && (j-i+1 > maxLen)){
                    palindromeStartsAt = i;
                    maxLen = j - i + 1;
                }
            }
        }
        
        return s.substring(palindromeStartsAt, palindromeStartsAt + maxLen);
    }
}

// credits @jeantimex for solution and @sleeter for comments on leetcode