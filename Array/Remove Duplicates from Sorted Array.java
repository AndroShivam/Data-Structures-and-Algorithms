// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        
        int[] temp = new int[n];
        int j = 0;
        
        for(int i=0; i<n-1; i++){
            if(nums[i] != nums[i + 1])
                temp[j++] = nums[i];
        }
        
        temp[j++] = nums[n - 1];
        
        for(int i=0; i<j; i++)
            nums[i] = temp[i];
        
        return j;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        
        int j = 0;
        
        for(int i=0; i<n-1; i++){
            if(nums[i] != nums[i + 1])
                nums[j++] = nums[i];
        }
         
        // Store the last element as whether 
        // it is unique or repeated, it hasn't 
        // stored previously 
        nums[j++] = nums[n - 1];
        return j;
    }
}