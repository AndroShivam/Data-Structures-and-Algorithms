// Using Stack

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int calculate(String s) {
        if(s.isEmpty() || s == null) return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        int n = s.length();
        char sign = '+';
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
                num = num * 10  + s.charAt(i) - '0';
            
            if((!Character.isDigit(c) && c != ' ') || i == n - 1){
                if(sign == '+')
                    stack.push(num);
                if(sign == '-')
                    stack.push(-num);
                if(sign == '*')
                    stack.push(stack.pop() * num);
                if(sign == '/')
                    stack.push(stack.pop() / num);
                
                sign = c;
                num = 0;
            }
        }
        
        int result = 0;
        
        while(!stack.isEmpty())
            result += stack.pop();
        
        return result;
    }
}