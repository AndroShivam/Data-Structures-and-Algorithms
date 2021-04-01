class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        return Math.max(robber(nums,0, n - 2), robber(nums,1,  n - 1));
    }
    
    private int robber(int[] nums, int low, int high){
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i=low; i<=high; i++){
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i] , prev1);
            prev2 = temp;
        }
        
        return prev1;
    }
}