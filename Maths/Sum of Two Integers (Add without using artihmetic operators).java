class Solution {
    public int getSum(int a, int b) {
        
        while(b != 0){
            int carry = (a & b); // carry is produced when (1,1) occur and 1 & 1 is 1
            a = a ^ b; // xor gives result for (1,0), (0,1) and (0,0)
            b = (carry) << 1; // for (1,1) addition we produce result as 0 and carry 1 is shifted to the left
        }
        
        return a;
    }
}