// Brute Force O(N^2)

class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxValue = 0;
        
        for(int i=0; i<nums.length; i++){
            int currentMax = 0;
            
            for(int j=i; j<nums.length; j++){
                currentMax += nums[j];
                if(currentMax > maxValue){
                    maxValue = currentMax;
                }
            }
        }
        
        return maxValue;
    }
}

// Kadane's Algorithm O(N)
 
class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int currentMax = nums[0];
        
        for(int i=1; i<nums.length; i++){
            currentMax = Math.max(nums[i] + currentMax, nums[i]);
            max = Math.max(currentMax, max);
        }
        
        return max;
    }
}