// Using Stack

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public String removeDuplicates(String S) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : S.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}

// Using StringBuilder

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray()){
            int size = sb.length();
            if(size > 0 && sb.charAt(size - 1) == c)
                sb.deleteCharAt(size - 1);
            else
                sb.append(c);
        }
        return sb.toString();
    }
}


// Using Two Pointers

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public String removeDuplicates(String S) {
        
        char[] s = S.toCharArray();
        int end = -1;
        
        for(char c : s){
            if(end >= 0 && s[end] == c)
                end--;
            else
                s[++end] = c;
        }
        
        return String.valueOf(s, 0, end + 1);
    }
}