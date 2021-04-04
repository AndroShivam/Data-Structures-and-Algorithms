// Brute Force 

// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int n = T.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            for(int j = i + 1; j<n; j++){
                if(T[i] < T[j]){
                    result[i] = j - i;
                    break;
                }
            }
        }    
        return result;
    }
}

// Using Stack

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> stack = new Stack<>();
        int n = T.length;
        int[] result = new int[n];
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        
        return result;
    }
}