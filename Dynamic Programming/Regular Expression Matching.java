// Time Complexity - O(N^2)
// Space Complexity - O(N^2)

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                else if(i == 0)
                    dp[i][j] = false;
                else if(j == 0){
                    char pat = p.charAt(i - 1);
                    if(pat == '*')
                        dp[i][j] = dp[i - 2][j];
                    else
                        dp[i][j] = false;
                }else{
                    char patt = p.charAt(i - 1);
                    char str = s.charAt(j - 1);
                    
                    if(patt == '*'){
                        dp[i][j] = dp[i - 2][j];
                        char patternLastChar = p.charAt(i - 2);
                        if(patternLastChar == '.' || patternLastChar == str)
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }else if(patt == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if(patt == str)
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = false;
                        
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}

// Video Explanation - https://youtu.be/DJvw8jCmxUU