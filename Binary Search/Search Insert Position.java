class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return low;
    }
}

// Q - Why return low at the end ?
// A - Because the terminating condition in your loop depends on the low as soon as it gets more than high the loop terminates which means now your value is at the desired place. In short- terminating condition decides the return value outside the loop.

// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1