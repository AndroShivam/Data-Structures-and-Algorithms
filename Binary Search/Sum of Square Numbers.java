// Brute Force

// Time Complexity - O(c)
// Space Complexity - O(1)

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }
}

// Using Math Sqrt

// Time Complexity - O(sqrt(c)Logc)
// Space Complexity - O(1)

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}

// Binary Search

// Time Complexity - O(sqrt(c))
// Space Complexity - O(1)

class Solution {
    public boolean judgeSquareSum(int c) {
        
        int left = 0;
        int right = (int)Math.sqrt(c);
        
        while(left <= right){
            int current = left * left + right * right;
            
            if(current < c)
                left++;
            else if(current > c)
                right--;
            else
                return true;
        }
        
        return false;
    }
}