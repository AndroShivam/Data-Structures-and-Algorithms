// Time Complexity - O(N^2)

class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int maxProduct = Integer.MIN_VALUE;
        int product = 1;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
            product = 1;
        }
        
        return maxProduct;
    }
}

// Time Complexity - O(N)

class Solution {
    public int maxProduct(int[] nums) {
        
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxSum = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] < 0){ // multiplying two negative numbers can give max product
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);  
            
            maxSum = Math.max(maxSum, currentMax);
        }
        
        return maxSum;
    }
}