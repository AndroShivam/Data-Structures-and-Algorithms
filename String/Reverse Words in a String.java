// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public String reverseWords(String s) {
        
        int i = s.length() - 1;
        StringBuilder result = new StringBuilder();
        
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' ')
                i--;
            
            int j = i;
            
            if(i < 0) break;

            while(i >= 0 && s.charAt(i) != ' ')
                i--;
            
            if(result.length() == 0){
                result.append(s.substring(i + 1, j + 1));
            }else{
                result.append(" ").append(s.substring(i + 1, j + 1));
            }
        }
        
        return result.toString();
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public String reverseWords(String s) {
        
        if(s == null)
            return null;
        
        char[] c = s.toCharArray();
        int n = c.length;
        
        // reverse the whole string 
        reverse(c, 0, n - 1);
        
        // reverse each word
        reverseWords(c, n);
        
        // clean up spaces
        return cleanSpaces(c, n);
    }
    

    private static void reverseWords(char[] c, int n){
        int i = 0, j = 0;
        
        while(i < n){
            while(i < j || i < n && c[i] == ' ') // skip spaces
            i++;
        
            while(j < i || j < n && c[j] != ' ') // skip non spaces
                j++;

            reverse(c, i, j - 1);  //reverse the word
        }
    }
    
    private static void reverse(char[] c, int start, int end){
        while(start < end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            
            start++;
            end--;
        }
    }
    
    
    private static String cleanSpaces(char[] c,int n){
        int i = 0, j = 0;
        
        while(j < n){
            while(j < n && c[j] == ' ') // skip spaces
                j++;
            
            while(j < n && c[j] != ' ') // keep non spaces
                c[i++] = c[j++];
            
            while(j < n && c[j] == ' ') // skip spaces
                j++;
            
            if(j < n)  // keep only one space
                c[i++] = ' '; 
        }
        
        return new String(c).substring(0, i);
        
    }
}

// solution by jeantimex
// https://leetcode.com/problems/reverse-words-in-a-string/discuss/47720/Clean-Java-two-pointers-solution-(no-trim(-)-no-split(-)-no-StringBuilder)