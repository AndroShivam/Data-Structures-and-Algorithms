class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;        
        if(n < 5) return 0;
        
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i=0; i<4; i++)
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        
        return res;
    }
}

// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/discuss/730567/JavaC%2B%2BPython-Straight-Forward