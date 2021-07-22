// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        
        for(int num : nums)
            xor ^= num;
        
        int mask = -xor & xor; // get the last set bit i.e xor = 6 then mask = -6 & 6 = 0000 0010 = 2
            
        int single1 = 0;
        int single2 = 0;
        
        for(int num : nums){
            if((mask & num) == 0) // numbers having last set bit = 0
                single1 ^= num;
            else // numbers having last set bit 1
                single2 ^= num;
        }
        
        return new int[]{single1, single2};
    }
}

// Explanation - https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution