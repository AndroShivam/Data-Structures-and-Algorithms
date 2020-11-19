class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = 1;
        for(int i=1; i<nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        
        for(int i = n - 1; i>=0; i--){
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        
        return res;
    }
}

// Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:

// Numbers:     2    3    4     5
// Lefts:            2  2*3 2*3*4
// Rights:  3*4*5  4*5    5      
// Let�s fill the empty with 1:

// Numbers:     2    3    4     5
// Lefts:       1    2  2*3 2*3*4
// Rights:  3*4*5  4*5    5     1

// Explanation by kingsizebeast on leetcode
// discussion link - https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space