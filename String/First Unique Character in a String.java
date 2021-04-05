// Using HashMap

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }
}

// Using Frequency Array

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        
        for(int i=0; i<n; i++){
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a'; 
            if(count[index] == 1)
                return i;
        }
        
        return -1;
    }
}