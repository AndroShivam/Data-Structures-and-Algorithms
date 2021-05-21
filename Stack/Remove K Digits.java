// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        
        Stack<Character> stack = new Stack<>();
        
        int i = 0;
        while(i < n){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        while(k > 0){ // corner case for "1111"
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        while(sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
            sb.deleteCharAt(sb.length() - 1);
        
        return sb.reverse().toString();

    }
}