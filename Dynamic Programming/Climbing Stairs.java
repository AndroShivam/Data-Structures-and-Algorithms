// Using Fibonacci Sequence 
// Time Complexity - O(N)

class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        
        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        int allWays = 0;
        
        for(int i=2; i<n; i++){
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        
        return allWays;
    }
}

// Dynamic Programming
// Time Complexity - O(N)

class Solution {
    public int climbStairs(int n) {
        
        if(n <= 2) return n;
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i=2; i<n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n - 1];
    }
}

/*

Explanation

-> 3

1 + 1 + 1
1 + 2
2 + 1

-> 4 

1 + 1 + 1 + 1
1 + 1 + 2
1 + 2 + 1
1 + 1 + 2
2 + 2

-> 5
1 + 1 + 1 + 1 + 1
1 + 1 + 1 + 2
1 + 1 + 2 + 1
1 + 2 + 1 + 1
2 + 1 + 1 + 1
2 + 2 + 1
1 + 2 + 2
2 + 1 + 2


for 3 -> 3
for 4 -> 5
for 5 -> 8
for 6 -> 13
..
for 9 -> 55

its forming The Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55

*/