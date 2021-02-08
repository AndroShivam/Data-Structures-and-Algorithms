class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        int firstOccurrence = findOccurrence(nums, target, 0);
        int secondOccurrence = findOccurrence(nums, target, 1);
        
        return (firstOccurrence == -1) ? new int[]{-1,-1} : new int[]{firstOccurrence, secondOccurrence};
    }
    
    private int findOccurrence(int[] nums, int target, int flag){
        
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target){
                if(flag == 0){
                    end = mid - 1;
                    result = mid;
                }else{
                    start = mid + 1;
                    result = mid;
                }
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return result;
    }
}