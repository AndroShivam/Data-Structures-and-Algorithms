class Solution {
    public int scoreOfParentheses(String S) {
        
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        
        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push(current);
                current = 0;
            }else{
                current = stack.pop() + Math.max(2 * current , 1);
            }
        }
        
        return current;
    }
}