// Method 1  
// Time Complexity - O(Log n)

class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n <= 0)
            return false;
        
        while(n % 2 == 0){
            n /= 2;
        }
        
        return n == 1;
    }
}

// Method 2
// Time Complexity - O(1)

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
}


// Explanation for Method 2
// If n is the power of two:

// n = 2 ^ 0 = 1 = 0b0000...00000001, and (n - 1) = 0 = 0b0000...0000.
// n = 2 ^ 1 = 2 = 0b0000...00000010, and (n - 1) = 1 = 0b0000...0001.
// n = 2 ^ 2 = 4 = 0b0000...00000100, and (n - 1) = 3 = 0b0000...0011.
// n = 2 ^ 3 = 8 = 0b0000...00001000, and (n - 1) = 7 = 0b0000...0111.
// we have n & (n-1) == 0b0000...0000 == 0

// Otherwise, n & (n-1) != 0.

// For example, n =14 = 0b0000...1110, and (n - 1) = 13 = 0b0000...1101.

// credits to motorix on leetcode