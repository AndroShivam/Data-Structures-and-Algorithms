// Using Inbuilt Function

public class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

// Bit Manipulation

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int ones = 0;
        
        while(n != 0){
            ones = ones + (n & 1);
            n = n>>>1;
        }
        
        return ones;
    }
}

// An Integer in Java has 32 bits, e.g. 00101000011110010100001000011010.
// To count the 1s in the Integer representation we put the input int
// n in bit AND with 1 (that is represented as
// 00000000000000000000000000000001, and if this operation result is 1,
// that means that the last bit of the input integer is 1. Thus we add it to the 1s count.
// ones = ones + (n & 1);

// Then we shift the input Integer by one on the right, to check for the
// next bit.
// n = n>>>1;

// We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)

// We keep doing this until the input Integer is 0.