// Brute Force

// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for(int i=0; i<n; i++){
            int currentProduct = 1;
            for(int j=0; j<n; j++){
                if(i != j){
                    currentProduct *= nums[j];
                }
            }
            result[i] = currentProduct;
        }
        
        return result;
    }
}

// Using left and right arrays (product at index i is everything on the left and right of i)

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1; // left of first number is nothing
        
        for(int i = 1; i<n; i++)
            left[i] = left[i - 1] * nums[i - 1];
        
        right[n - 1] = 1; // right of last number is nothing
        
        for(int i = n - 2; i>=0; i--)
            right[i] = right[i + 1] * nums[i + 1];
        
        for(int i=0; i<n; i++)
            result[i] = left[i] * right[i];
        
        return result;
    }
}

// Store left array in result and multiply right on the way to it

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        
        result[0] = 1;
        
        for(int i=1; i<n; i++) // treat result array as left array
            result[i] = result[i - 1] * nums[i - 1];
        
        int right = 1;
        
        for(int i = n - 1; i >= 0; i--){ // multiply right 
            result[i] *= right;
            right *= nums[i];
        }
        
        return result;
    }
}