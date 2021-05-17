// Built in function

int reverseBits(int n) {
  return Integer.reverse(n);
}

// Using Bit Manipulation
// Time Complexity - O(1)
// Space Complexity - O(1)


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        for(int i=0; i<32; i++){
            int end = n & 1;
            n = n >> 1;
            result = result << 1;
            result = result | end;
        }
        
        return result;
    }
}