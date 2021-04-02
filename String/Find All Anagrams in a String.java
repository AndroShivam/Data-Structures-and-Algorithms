class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        
        int[] hash = new int[26];
        for(char c : p.toCharArray())
            hash[c - 'a']++;
        
        while(right < sLen){
            if(hash[s.charAt(right) - 'a'] > 0){
                hash[s.charAt(right) - 'a']--;
                right++;
            }else{
                hash[s.charAt(left) - 'a']++;
                left++;
            }
            
            if(right - left == pLen)
                result.add(left);
        }
        
        return result;
    }
}