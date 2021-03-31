class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        
        int index2 = 0, index3 = 0, index5 = 0;
        
        for(int i=1; i<n; i++){
            nums[i] = min(nums[index2] * 2, nums[index3] * 3, nums[index5] * 5);
            
            if(nums[i] == nums[index2] * 2) index2++;
            if(nums[i] == nums[index3] * 3) index3++;
            if(nums[i] == nums[index5] * 5) index5++;
        }
        
        return nums[n - 1];
    }
    
    private int min(int a, int b, int c){
        int smallest = a;
        if(smallest > b) smallest = b;
        if(smallest > c) smallest = c;
        return smallest;
    }
}