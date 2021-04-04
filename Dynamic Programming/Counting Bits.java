// Brute Force

// Time Complexity - O(N * max(binary(n)))
// Space Complexity - O(1)

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        
        for(int i=0; i<=num; i++){
            int count = convertToBinary(i);  
            result[i] = count;
        }
        
        return result;
    }

    private int convertToBinary(int n){
        int binary = 0, count = 0, i = 1;
        while(n != 0){
            int rem = n % 2;
            count += rem;
            binary += rem * i;
            i *= 10;
            n /= 2;
        }
        return count;
    }
}

// Dynamic Programming

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        
        int[] dp = new int[num + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=num; i++){
            if(i % 2 == 0) // for even numbers we just left shift numbers i.e 32 is 100000 and 64 is 1000000. hence number of 1's remain same
                dp[i] = dp[i/2];
            else // for odd numbers i.e 7 we check number of 1's at 6 and add 1 to it
                dp[i] = dp[i/2] + 1;
        }
        
        return dp;
    }
}