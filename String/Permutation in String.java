// Time Compelexity - O(N)
// Space Complexity - O(1)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        
        int[] count = new int[26];
        
        for(char c : s1.toCharArray())
            count[c - 'a']++;
        
        for(int i=0; i<len2; i++){
            count[s2.charAt(i) - 'a']--;
            if(i - len1 >= 0)
                count[s2.charAt(i - len1) - 'a']++; // once out of window (left) revert values to original
            if(allZeros(count)) return true;
        }
        
        return false;
    }
    
    private boolean allZeros(int[] count){
        for(int i=0; i<count.length; i++){
            if(count[i] != 0)
                return false;
        }
        return true;
    }
}