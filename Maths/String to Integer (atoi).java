class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int i = 0;
        int result = 0;
        int sign = 1;
        int n = s.length();
        
        // remove whitespaces in the beginning
        while(i < n && s.charAt(i) == ' ')
            i++;
        
        // check if optional sign exists
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        
        // Build the result and check for overflow/underflow condition
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + (s.charAt(i++) - '0'); // - '0' to convert char to int
        }
        
        return result * sign;
    }
}

/*
Explanation

Integer.MAX_VALUE = 2147483647
Integer.MAX_VALUE/10 = 2147483640
Integer.MAX_VALUE % 10 = 7

base > Integer.MAX_VALUE / 10 i.e. base>2147483640 (Ex: if base = 2147483641 ,then when multiplied by 10,It would lead to overflow)
base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7
EX: Then base = 2147483640 + (Any addition greater than 7 would lead to integer overflow)
Hope this helps :)

credits to @Iwillcrackit on leetcode
*/

