// Sieve of Eratosthenes
// Time complexity - O(n*log(log(n))) 
// Space Complexity - O(N)

class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i = 2; i < Math.sqrt(n); i++){
            if(isPrime[i]){
                for(int j=i*i; j<n; j+=i)
                    isPrime[j] = false;
            }
        }
        
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(isPrime[i])
                count++;
        }
        
        return count;
    }
}