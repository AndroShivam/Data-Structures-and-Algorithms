// First Method (Sort both string and compare)  (O(nLogN))
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        
        String sorted1 = sort(s);
        String sorted2 = sort(t);
        
        for(int i=0; i<sorted1.length(); i++){
            if(sorted1.charAt(i) != sorted2.charAt(i))
                return false;
        }
        
        return true;
    }
    
    private static String sort(String str){
        char[] c = str.toCharArray();
        
        Arrays.sort(c);
        
        return new String(c);
    }
}

// Second Method (keep a count array , increment for the first string and decrement for the second string)
// if somewhere in the array value is not 0 then not anagram O(N)
class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] count = new int[26];
        
        for(char c : s.toCharArray())
            count[c - 'a']++;
        
        for(char c : t.toCharArray()){
            count[c - 'a']--;
            if(count[c - 'a'] < 0)
                return false;
        }
        
        for(int c : count){
            if(c != 0)
                return false;
        }
        
        return true;
    }
}