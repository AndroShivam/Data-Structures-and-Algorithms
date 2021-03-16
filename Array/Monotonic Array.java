// An array A is monotone increasing if for all i <= j, A[i] <= A[j].  
// An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

// Two Pass
// Time Complexity - O(N)

class Solution {
    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }
    
    private boolean increasing(int[] nums){
        for(int i=0; i<nums.length - 1; i++)
            if(nums[i] > nums[i + 1]) return false;
        return true;
    }
    
    private boolean decreasing(int[] nums){
        for(int i=0; i<nums.length - 1; i++)
            if(nums[i] < nums[i + 1]) return false;
        return true;
    }
}

// One Pass
// Time Complexity - O(N)

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for(int i=0; i<A.length - 1; i++){
            if(A[i] > A[i + 1])
                increasing = false;
            if(A[i] < A[i + 1])
                decreasing = false;
        }
        
        return increasing || decreasing;
    }
}