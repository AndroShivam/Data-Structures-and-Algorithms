// Using Extra Space

// Time Complexity - O(N^2)
// Space Complexity - O(N)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        for(int i=1; i<=nums.length; i++)
            result.add(i);
        
        for(int num : nums){
            if(result.contains(num))
                result.remove(new Integer(num));
        }
        return result;
    }
}

// Constant Space

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0 || nums == null) return result;
        
        for(int num : nums){
            int index = Math.abs(num);
            
            if(nums[index - 1] > 0){
                nums[index - 1] = -nums[index - 1];
            }
        }
        
        for(int i=1; i<=nums.length; i++){
            if(nums[i - 1] > 0){
                result.add(i);
            }
        }
        
        return result;
    }
}