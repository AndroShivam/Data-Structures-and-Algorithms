class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch))
                k = k * 10 + ch - '0';
            else if(ch == '['){
                intStack.push(k);
                strStack.push(current);
                current = new StringBuilder();
                k = 0;
            }else if(ch == ']'){
                StringBuilder temp =  current;
                current = strStack.pop();
                
                for(int i=intStack.pop(); i>0; i--)
                    current.append(temp);
            }else 
                current.append(ch);
        }
        
        return current.toString();
    }
}
