// Brute Force

// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int left = Integer.MAX_VALUE;
        int right = 0;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    right = Math.max(right, j);
                    left = Math.min(left, i);
                }
            }
        }
        return (right - left < 0) ? 0 : right - left + 1;
    }
}

// Using Sorting

// Time Complexity - O(NLogN)
// Space Complexity - O(N)

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        
        int start = Integer.MAX_VALUE;
        int end = 0;
        
        for(int i=0; i<nums.length; i++){
            if(temp[i] != nums[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        
        return (end - start < 0) ? 0 : end - start + 1; 
    }
}

// Using Two Passes

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int end = -2;
        
        //iterate from beginning of array
        //find the last element which is smaller than the last seen max from 
        //its left side and mark it as end
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max)
                end = i;
        }
        
        int min = Integer.MAX_VALUE;
        int start = -1;
        
        //iterate from end of array
        //find the last element which is bigger than the last seen min from 
        //its right side and mark it as start
        for(int i=nums.length-1; i>=0; i--){
            min = Math.min(min, nums[i]);
            if(nums[i] > min)
                start = i;
        }
        
        return end - start + 1;
    }
}