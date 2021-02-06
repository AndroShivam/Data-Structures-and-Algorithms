class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = 0;
        int tail = s.length() - 1;
        
        while(tail >= 0 && s.charAt(tail) == ' ') // remove any extras spaces at the end of the string
            tail--;
        
        while(tail >= 0 && s.charAt(tail) != ' '){ // count the last word length
            len++;
            tail--;
        }
        
        return len;
    }
}