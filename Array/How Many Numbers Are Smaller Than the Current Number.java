// Time Complexity - O(N)
// Space Complexity - O(N), for result

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[101];
        int[] result = new int[n];
        
        for(int num : nums)
            count[num]++;
        
        for(int i=1; i<101; i++)
            count[i] += count[i - 1];
        
        
        for(int i=0; i<n; i++){
            if(nums[i] == 0)
                result[i] = 0;
            else
                result[i] = count[nums[i] - 1];
        }
        return result;
    }
}