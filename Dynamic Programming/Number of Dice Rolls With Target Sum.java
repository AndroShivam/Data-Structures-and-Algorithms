// Time Complexity - O(f^d)
// Space Complexity - O(f)

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if(d == 0 || target < 0)
            return target == 0 ? 1 : 0;
        
        int ways = 0;
        
        for(int i=1; i<=f; i++)
            ways += numRollsToTarget(d - 1, f, target - i);
        
        return ways;
    }
}

// Time Complexity - O(f * d * target)
// Space Complexity - O(d * target)

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] memo = new int[d + 1][target + 1];
        
        for(int[] cell : memo)
            Arrays.fill(cell, -1);
        
        return helper(d, f, target, memo);
    }
    
    private int helper(int d, int f, int target, int[][] memo){
        if(d == 0 || target < 0)
            return target == 0 ? 1 : 0;
        
        if(memo[d][target] != -1)
            return memo[d][target];
        
        int ways = 0;
        
        for(int i=1; i<=f; i++)
            ways = (ways + helper(d - 1, f, target - i, memo)) % 1000000007;
        
        return memo[d][target] = ways;
    }
}