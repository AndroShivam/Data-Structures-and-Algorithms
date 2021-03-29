// Brute Force

// Time Complexity - O(2^N)
// Space Complexity - O(N) (i.e depth of recursion)

class Solution {
    public int lengthOfLIS(int[] nums) {
        return findLIS(nums, Integer.MIN_VALUE, 0);
    }
    
    private int findLIS(int[] nums, int prev, int current){
        if(current == nums.length) return 0;
        
        int taken = 0;
        if(nums[current] > prev)
            taken = 1 + findLIS(nums, nums[current], current + 1);
        
        int notTaken = findLIS(nums, prev, current + 1);
        
        return Math.max(taken, notTaken);
    }
}

// Dynamic Programming

// Time Complexity - O(N^2)
// Space Complexity - O(N) 

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int max = 1;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}