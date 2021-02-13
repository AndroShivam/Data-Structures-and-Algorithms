// Brute Force 
// Time Complexity - Exponential

class Solution {
    public int uniquePaths(int m, int n) { 
        return countUniquePaths(0, 0, m, n);
    }
    
    private int countUniquePaths(int i, int j, int m, int n){
        if(i >= m || j >= n) return 0;
        if(i == m - 1 || j == n - 1) return 1;
        return countUniquePaths(i + 1, j, m, n) + countUniquePaths(i, j + 1, m, n);
    }
}

// Dynamic Programming
// Time Complexity = O(N * M)
// Space Complexity = O(N * M)

class Solution {
    public int uniquePaths(int m, int n) { 
        int[][] dp = new int[m][n];
        for(int[] cell : dp) // intialise dp with -1
            Arrays.fill(cell, -1);
        return countUniquePaths(0, 0, m, n, dp);
    }
    
    private int countUniquePaths(int i, int j, int m, int n,int[][] dp){
        if(i >= m || j >= n) return 0;
        if(i == m - 1 || j == n - 1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = countUniquePaths(i + 1, j, m, n,dp) + countUniquePaths(i, j + 1, m, n, dp);
    }
}

// Using Combination
// Time Complexity - O(M - 1) or O(N - 1)
// Space Complexity - O(1)

class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int R = m - 1;
        double res = 1;
        
        for(int i=1; i<=R; i++)
            res = res * (N - R + i)/i;
        
        return (int)res;
    }
}

/*
Explanation

let m = 3, n = 2
to reach the end cell we have following choices

Move Right -> Right -> Down
Move Down -> Right -> Right
Move Right -> Down -> Right

number of Right = m - 1
number of Down = n - 1

steps to take in every combination = m - 1 + n - 1 => (m + n - 2)

if we consider down 
DOWN right right
right DOWN right
right right DOWN

if we consider right
down RIGHT RIGHT
RIGHT down RIGHT
RIGHT RIGHT down

we will be using combination - NCR -> N!/R!(N - R)!
we can either use (m + n - 2)C(m - 1) or (m + n - 2)C(n - 1)
*/