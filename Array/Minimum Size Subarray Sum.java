// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i = 0, sum = 0, result = Integer.MAX_VALUE;
        
        for(int j=0; j<nums.length; j++){
            sum += nums[j];
                result = Math.min(result, j - i + 1);
                sum -= nums[i++];
            }
        }
        
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}