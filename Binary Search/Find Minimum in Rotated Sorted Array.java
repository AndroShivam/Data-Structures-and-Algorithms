class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            if(nums[start] < nums[end]) // if array is not rotated
                 return nums[start];
            
            int mid = start + (end - start)/2;
            
            if(nums[mid] >= nums[start]) // rotation is from mid + 1 to end
                start = mid + 1;
            else
                end = mid;
        }
        
        return nums[start];
    }
}