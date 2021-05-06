// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int currentFarthest = 0, currentEnd = 0, jumps = 0;
        
        for(int i=0; i<n - 1; i++){
            currentFarthest = Math.max(currentFarthest, i + nums[i]);
            if(i == currentEnd){
                jumps++;
                currentEnd = currentFarthest;
                
                if(currentEnd >= n - 1) break;
            }
        }
        
        return jumps;
    }
}