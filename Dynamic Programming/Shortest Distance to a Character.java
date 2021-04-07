class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        
        int[] dp = new int[n];
        
        for(int i=0; i<n; i++){
            if(s.charAt(i) != c)
                dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<n - 1; i++){
            if(dp[i] != Integer.MAX_VALUE){
                dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
            }
        }
        
        for(int i=n-1; i>0; i--){
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }
        
        return dp;
    }
}

// Explanation
// https://leetcode.com/problems/shortest-distance-to-a-character/discuss/126116/Concise-java-solution-with-detailed-explanation.-Easy-understand!!!