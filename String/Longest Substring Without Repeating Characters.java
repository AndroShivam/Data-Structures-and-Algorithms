// Brute Force
// Time Complexity : O(N^3)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int ans = 0;
        
       for(int i=0; i<n; i++)
           for(int j=i+1; i<=n; j++)
               if(allUnique(s,i,j))
                   ans = Math.max(ans, j - i);
        
        return ans;
        
    }
    
    private boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i=start; i<end; i++){
            char ch = s.charAt(i);
            if(set.contains(ch))
                return false;
            set.add(ch);
        }
        
        return true;
    }
}



// Sliding Window
// Time Complexity : O(2n) = O(n) In the worst case each character will be visited twice by ii and jj.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}


// Above Approach further more optimized
// Time complexity : O(n) Index j will iterate n times.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int i=0,j=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            
            map.put(s.charAt(i),i);
            max = Math.max(max, i - j + 1);
        }
        
        return max;
    }
}
