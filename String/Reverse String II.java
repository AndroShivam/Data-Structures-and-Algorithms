class Solution {
    public String reverseStr(String s, int k) {
        
        char[] c = s.toCharArray();
        int n = s.length();
        
        for(int i=0; i<n; i += 2*k){
            int j = Math.min(i + k - 1, n - 1);
            reverse(c, i, j);
        }
        
        return new String(c);
    }
    
    private void reverse(char[] c, int start, int end){
        while(start < end){
            char temp = c[start];
            c[start++] = c[end];
            c[end--] = temp;
        }
    }
}

