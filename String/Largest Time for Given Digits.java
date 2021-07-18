// Time Complexity - O(1)
// Space Complexity - O(1)

class Solution {
    private int max = -1;
    public String largestTimeFromDigits(int[] arr) {
        permutate(arr, 0);
        if(max == -1)
            return "";
        else
            return String.format("%02d:%02d", max / 60, max % 60);
    }
    
    private void permutate(int[] nums, int start){
        if(start == nums.length){
            buildTime(nums);
            return;
        }else{
            for(int i=start; i<nums.length; i++){
                swap(nums, i, start);
                permutate(nums, start + 1);
                swap(nums, i, start); // backtrack
            }
        }
    }
    
    private void buildTime(int[] perm){
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if(hour < 24 && minute < 60)
            max = Math.max(max, hour * 60 + minute);
    }
    
    private void swap(int[] nums, int i, int j){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}