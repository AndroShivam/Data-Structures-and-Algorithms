// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        
        int maxSum = A[0];
        int minSum = A[0];
        
        int curMax = 0;
        int curMin = 0;
        int total = 0;
        
        for(int a : A){
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}

// Video Explanation - https://youtu.be/Q1TYVUEr-wY
// Leetcode Discussion - https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass