class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        
        int closet = nums[0] + nums[1] + nums[2]; // random closet at the beginning
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length - 2; i++){
            int start = i + 1;
            int end = nums.length - 1;
            
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];

                if(Math.abs(sum - target) < Math.abs(closet - target))
                    closet = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return sum;
                
            }
        }
        
        return closet;
        
    }
}