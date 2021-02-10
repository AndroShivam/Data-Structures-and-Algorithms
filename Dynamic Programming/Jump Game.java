// Dynamic Programming

enum Index {
    GOOD, BAD, UNKNOWN
}

class Solution {
    public boolean canJump(int[] nums) {
        
        Index[] memo = new Index[nums.length];
        for(int i=0; i<memo.length; i++){
            memo[i] = Index.UNKNOWN;
        }
        
        memo[memo.length - 1] = Index.GOOD;
        
        for(int i=nums.length - 2; i>=0; i--){
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for(int j=i+1; j<=furthestJump; j++){
                if(memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        
        return memo[0] == Index.GOOD;
    }
}

// Greedy 

class Solution {
    public boolean canJump(int[] nums) {
        
        int lastPos = nums.length - 1;
        
        for(int i=nums.length - 1; i>=0; i--){
            if(i + nums[i] >= lastPos){ // The largest index that can be reached is: i + A[i].
                lastPos = i;
            }
        }
        
        return lastPos == 0;
    }
}