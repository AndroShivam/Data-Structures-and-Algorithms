// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public double myPow(double x, int n) {
        
        double res = 1;
        for(int i=0; i<Math.abs(n); i++){
            res *= x;
        }
        
        return (n < 0) ? (1/res) : res;
    }
}

// Time Complexity - O(LogN) -> as we are dividing n by 2 whenever we get n = even
// Space Complexity - O(1)

class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long num = n;
        
        if(num < 0)
            num = -1 * num;
        
        while(num > 0){
            if(num % 2 == 0){
                x = x * x;
                num = num / 2;
            }else{
                res = res * x;
                num = num - 1;
            }
        }
        
        
        return (n < 0) ? (1/res) : res;
    }
}

/*

Explanation

for x = 2 and n = 10

2^10 = (2 * 2)^5 = (4)^5

4^5 = 4 * (4)^4

4^4 = (4 * 4)^2 = (16)^2

16^2 = (16 * 16)^1  = (256)^1

(256)^1 = 256 * (256)^0

*/