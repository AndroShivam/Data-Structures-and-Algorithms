class Solution {
    public void nextPermutation(int[] nums) {
        
        if(nums == null || nums.length <= 1)
            return;
        
        int i = nums.length - 2;
        
        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;
        
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[i] >= nums[j])
                j--;
            
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end){
        
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
}



// 1 3 5 4 2
/*

  
1 3  5              // increasing sequence from right to left i.e 2 to 5
      4 
        2

*/