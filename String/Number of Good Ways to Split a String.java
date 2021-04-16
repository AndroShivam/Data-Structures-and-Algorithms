// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int numSplits(String s) {
        
        int n = s.length();
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Set<Character> set1 = new HashSet<>();
        
        for(int i=0; i<n; i++){
            set1.add(s.charAt(i));
            left[i] = set1.size();
        }
        
        Set<Character> set2 = new HashSet<>();
        
        for(int i=n-1; i>=0; i--){
            right[i] = set2.size();
            set2.add(s.charAt(i));
        }

        int count = 0;
        
        for(int i=0; i<n; i++)
            if(left[i] == right[i])
                count++;
        
        return count;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1s)

class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        
        int leftUnique = 0;
        int rightUnique = 0;
        int result = 0;
        
        for(char c : s.toCharArray()){
            if(right[c - 'a']++ == 0) rightUnique++;
        }
        
        for(char c : s.toCharArray()){
            if(left[c - 'a']++ == 0) leftUnique++;
            if(--right[c - 'a'] == 0) rightUnique--;
            
            if(leftUnique == rightUnique) result++;
        }
        
        return result;
    }
}