// O(N^2) Solution

class Solution {
    public int longestValidParentheses(String s) {
        
            int max = 0;

            for(int i=0; i<s.length(); i++){
                for(int j=i+1; j<=s.length(); j++){
                    if(isValid(s, i, j)){
                        int len = j - i;
                        if(len > max){
                            max = len;
                        }
                    }
                }
            }
        
        return max;
    }
    
   private boolean isValid(String s, int start, int end){
        
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(int i=start; i<end; i++){
            if(c[i] == '(')
                stack.push(c[i]);
            else if(c[i] == ')'){
                if(stack.isEmpty() || !arePairs(stack.peek(), c[i]))
                    return false;
                
                stack.pop();
            }
        }
       
       return stack.isEmpty();
    }
    
    private boolean arePairs(char op, char cl){
        if(op == '(' && cl == ')')
            return true;
        return false;
    }
}



// O(N) Solution

class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        int max = 0;
        char[] c = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            if(c[i] == '(')
                stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    max = Math.max(max, i - stack.peek());
            }
        }
        
        return max;
    }
}

// s = ")()())"