// Time Complexity - O(LogN^2)
// Space Complexity - O(1)

class Solution {
    public int divide(int dividend, int divisor) {
        if(Integer.MIN_VALUE == dividend && divisor == -1)
            return Integer.MAX_VALUE;
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        
        while(a - b >= 0){
            int temp = b;
            int count = 1;
            while(a - (temp << 1) >= 0){
                temp = temp << 1; // temp = temp * 2;
                count = count << 1; // count = count * 2;
            }
            a -= temp;
            res += count;
        }
        
        return (dividend > 0) == (divisor > 0) ? res : - res;
    }
}