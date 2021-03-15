// SOLUTION 1
// Time Complexity - O(LogN)

class Solution {
    public int addDigits(int num) {
        
        int digitRoot = 0;
        
        while(num > 0){
            digitRoot += num % 10;
            num /= 10;
            
            if(num == 0 && digitRoot > 9){
                num = digitRoot;
                digitRoot = 0;
            }
        }
        
        return digitRoot;
    }
}

/*
for 38 -> 11 -> 2
nums == 0 means we have consumed a 2 digit number 
digitRoot > 9 means if we are still left with a 2 digit number we need to evalue it again so assign num = digitRoot
*/


// SOLUTION 2
// Time Complexity - O(1)

class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        if(num % 9 == 0) return 9; 
        return num % 9; 
    }
}

/*
@credits - @kachebb on leetcode

I'll try to explain the math behind this:

First you should understand:

10^k % 9 = 1
a*10^k % 9 = a % 9 
Then let's use an example to help explain.

Say a number x = 23456

x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6

2 * 10000 % 9 = 2 % 9

3 * 1000 % 9 = 3 % 9

4 * 100 % 9 = 4 % 9

5 * 10 % 9 = 5 % 9

Then x % 9 = ( 2+ 3 + 4 + 5 + 6) % 9, note that x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6

So we have 23456 % 9 = (2 + 3 + 4 + 5 + 6) % 9

// In Code
// line 4 = summing of numbers divisible by 9 is always 9 i.e 18 -> 1 + 8 =  9, 54 -> 5 + 4 = 9
// line 5 = for ex. 27 -> 2 * 10 + 7 = 10 % 9 == 1 so, 2 * 1 + 7 hence, 9
*/
