class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=1; i<n; i++){
            s = countHelper(s);
        }
        return s;
    }
    
    private String countHelper(String s){
        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int count = 1;
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ch)
                count++;
            else{
                sb.append(count);
                sb.append(ch);
                ch = s.charAt(i);
                count = 1;
            }
        }
        
        sb.append(count);
        sb.append(ch);
        
        return sb.toString();
    }
}