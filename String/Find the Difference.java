// You are given two strings s and t.
// String t is generated by random shuffling string s and then add one more letter at a random position.
// Return the letter that was added to t

// Solution 1

class Solution {
    public char findTheDifference(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        
        int sums = 0;
        int sumt = 0;
        
        for(char c : chs)
            sums += (int)c;
        
        for(char c : cht)
            sumt += (int)c;
        
        return (char)(sumt - sums);
    }
}

// Solution 2

class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        
        for(char ch : s.toCharArray())
            res ^= ch;
        
        for(char ch : t.toCharArray())
            res ^= ch;
        
        return res;
    }   
}