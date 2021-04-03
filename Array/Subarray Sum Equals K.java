// Brute Force

// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            int currentSum = 0;
            for(int j=i; j<nums.length; j++){
                currentSum += nums[j];     
                if(currentSum == k)
                    count++;
            }
        }
        
        return count;
    }
}

// Using HashMap

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        int sum = 0, result = 0;
        
        for(int num : nums){
            sum += num;
            result += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}