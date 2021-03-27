// Using Set

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(n != 1){
            int temp = n;
            int sum = 0;
            
            while(temp > 0){
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }
            
            n = sum;
            
            if(set.contains(n))
                return false;
            else
                set.add(n);
        }
        
        return true;
    }
}

// Using Floyd's Cycle Detection

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = n;
        
        do{
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            
            if(fast == 1) return true;
        }while(slow != fast);
        
        return false;
    }
    
    private int digitSquareSum(int n){
        int temp = n;
        int sum = 0;
        
        while(temp != 0){
            int digit = temp % 10;
            sum += digit * digit;
            temp /= 10;
        }
        return sum;
    }
}