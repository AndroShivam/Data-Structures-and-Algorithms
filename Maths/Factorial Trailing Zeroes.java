class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        while(n != 0){
            int temp = n / 5;
            count += temp;
            n = temp;
        }
        
        return count;
    }
}

// we get a trailing 0 if factors of n contains 10 or 2 and 5
// 10 can further be broken down into 5 * 2
// so we can count either 2 or 5
// but even numbers also contain 2's
// so we have to only count 5