// Time Complexity - Best/Average Case O(LogN) and Worst Case O(N) (i.e all same)
// Space Complexity - O(1)

// Method 1 
// Add two while loops

class Solution {
    public boolean search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return true;

            while(low != mid && nums[low] == nums[mid]) low++; // skip duplicates
            while(mid != high && nums[mid] == nums[high]) high--; // i.e 1,3,1,1,1
            
            if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        
        return false;
    }
}

// Method 2
// Add one else if statement

class Solution {
    public boolean search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return true;
            
            if(nums[mid] > nums[low]){
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }else if(nums[low] == nums[mid]){
                low++;
            }else{
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        
        return false;
    }
}