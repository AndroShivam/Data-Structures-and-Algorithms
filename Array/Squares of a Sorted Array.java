// Time Complexity - O(NLogN)
// Space Complexity - O(N)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        
        for(int i=0; i<n; i++)
            temp[i] = nums[i] * nums[i];
        
        Arrays.sort(temp);
        
        return temp;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        
        for(int i=n-1; i>=0; i--){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[i] = nums[left] * nums[left];
                left++;
            }else{
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        
        return result;
    }
}
