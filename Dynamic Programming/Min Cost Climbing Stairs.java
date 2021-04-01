// Recursion with memoisation

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;   
        dp = new int[n];
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }
    
    private int minCost(int[] cost, int n){
        if(n < 0) return 0;
        if(n == 0 || n == 1) return cost[n];
        
        if(dp[n] != 0) return dp[n];
        
        return dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int first = cost[0];
        int second = cost[1];
        
        for(int i=2; i<n; i++){
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }
}