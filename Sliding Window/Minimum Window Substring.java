// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        
        for(char c : t.toCharArray())
            map[c]++;
        
        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int counter = t.length();
        
        while(end < s.length()){
            char c1 = s.charAt(end);
            if(map[c1] > 0)
                counter--;
            map[c1]--;
            end++;
            
            while(counter == 0){
                if(minLen > end - start){
                    minLen =  end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                // means c2's times is not exhust, so we need to find another c2 in next window 
                if(map[c2] > 0) counter++;
                start++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

// 1. Use two pointers: start and end to represent a window.
// 2. Move end to find a valid window.
// 3. When a valid window is found, move start to find a smaller window.