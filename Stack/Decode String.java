// Time Complexity - O(maxK*n) where maxK is max value of k & n is the size of string array.
// Space Complexity - O(m+n) m is no of letters and n is no of digits.

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        
        int k = 0;
        
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)) 
                k = k * 10 + ch - '0';
            else if(ch == '['){
                intStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            }else if(ch == ']'){
                StringBuilder temp = curr;
                curr = strStack.pop();
                for(int i = intStack.pop(); i>0; i--)
                    curr.append(temp);
            }else{
                curr.append(ch);
            }
        }
        
        return curr.toString();
    }
}

// Explanation for k = k * 10 + ch - '0'
// for 23[a], in first iteration 2 is added to k
// in second iteration k = 2 * 10 + 3 hence k = 20 + 3 = 23 
// -'0' for char to int conversion