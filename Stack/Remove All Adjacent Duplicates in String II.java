// Using Stack with Node

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().ch == ch)
                stack.peek().count++;
            else
                stack.push(new Node(ch, 1));
            
            if(stack.peek().count == k)
                stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            Node current = stack.pop();
            for(int i=0; i<current.count; i++)
                sb.append(current.ch);
        }
        
        return sb.reverse().toString();
    }
}

class Node{
    char ch;
    int count;
    public Node(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}

// Using StringBuilder as Stack

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public String removeDuplicates(String s, int k) {
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            sb.append(c);
            int last = sb.length() - 1;
            count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last-1) ? count[last - 1] : 0); 
            
            if(count[last] >= k)
                sb.delete(sb.length() - k, sb.length());
        }
        
        return sb.toString();
    }
}