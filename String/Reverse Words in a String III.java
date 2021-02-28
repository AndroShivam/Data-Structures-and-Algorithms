// Using Extra Space

class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        
        for(int i=0; i<str.length; i++)
            str[i] = new StringBuilder(str[i]).reverse().toString();
        
        StringBuilder result = new StringBuilder();
        
        for(String st : str)
            result.append(st + " ");
        
        return result.toString().trim();
    }
}

// Inline

class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        
        for(int i=0; i<ca.length; i++){
            if(ca[i] != ' '){
                int j = i;
                while(j + 1 < ca.length && ca[j + 1] != ' ') 
                    j++;
                
                reverse(ca, i, j);
                i = j;
            }
        }
        
        return new String(ca);
    }
    
    private void reverse(char[] ca, int start, int end){
        while(start < end){
            char temp = ca[start];
            ca[start++] = ca[end];
            ca[end--] = temp;
        }
    }
}