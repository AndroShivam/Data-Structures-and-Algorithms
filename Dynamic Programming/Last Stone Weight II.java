class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int n = stones.length;
        int sum = 0;
        
        for(int stone : stones)
            sum += stone;
        
        int[][] dp = new int[n + 1][sum/2 + 1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum/2; j++){
                if(stones[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        
        return sum - 2 * dp[n][sum/2];
    }
}


// minimise s2 - s1
// ((sum - s1) - s1)
// sum - 2 * s1

// find maximum s1 so what sum - 2 * s1 can be minimised

// s1 > sum/2 will be negative so we take s1 between 0 to sum/2