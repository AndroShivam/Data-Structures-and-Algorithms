// Brute Force
// Time Complexity - O(2^N)
// Space Complexity - O(N) -> depth of the recursion tree can go upto N

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakUtil(s, wordDict, 0);
    }
    
    private static boolean wordBreakUtil(String str, List<String> dict, int start){
        if(start == str.length())
            return true;
        
        for(int end = start + 1; end <= str.length(); end++){
            if(dict.contains(str.substring(start, end)) && wordBreakUtil(str, dict, end))
                return true;
        }
        
        return false;
    }
}

// Recursion with memoization
// Time Complexity - O(N^3)
// Space Complexity - O(N) -> depth of the recursion tree can go upto N

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakUtil(s, wordDict, 0, new Boolean[s.length()]);
    }
    
    private static boolean wordBreakUtil(String str, List<String> dict, int start, Boolean[] memo){
        if(start == str.length())
            return true;
        
        if(memo[start] != null)
            return memo[start];
        
        for(int end = start + 1; end <= str.length(); end++){
            if(dict.contains(str.substring(start, end)) && wordBreakUtil(str, dict, end, memo))
                return memo[start] = true;
        }
        
        return memo[start] = false;
    }
}

// Breadth First Search
// Time Complexity - O(N^3)
// Space Complexity - O(N) -> depth of the recursion tree can go upto N


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            int start = queue.poll();
            if(!visited[start]){
                for(int end = start + 1; end <= s.length(); end++){
                    if(wordDictSet.contains(s.substring(start, end))){
                        queue.offer(end);   
                        if(end == s.length())
                            return true;
                    }
                }
            }
            
            visited[start] = true;
        }
        
        return false;
    }
}

// Dynamic Programming
// Time Complexity - O(N^3)
// Space Complexity - O(N) -> depth of the recursion tree can go upto N


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}