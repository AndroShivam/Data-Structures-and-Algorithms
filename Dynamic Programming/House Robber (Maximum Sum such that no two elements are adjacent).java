// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        
        return dp[nums.length - 1];
    }
}

// Time Complexity = O(N)
// Space Complexity - O(1)

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int prev1 = 0;
        int prev2 = 0;
        
        for(int num : nums){
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        
        return prev1;
    }
}

