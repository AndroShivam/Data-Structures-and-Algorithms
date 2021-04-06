class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = new int[nums.length];
        result = nums.clone();
        
        for(int i=0; i<nums.length; i++){
            int random = (int)(Math.random() * (nums.length - i)) + i;
            swap(result, i, random);
        }
        
        return result;
    }
    
    private void swap(int[] result, int i, int j){
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }
}