Time Complexity - O(n * klogn) where k is the average char length

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs == null || strs.length == 0) 
            return new ArrayList<>();
        
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            
            String sortedStr = new String(c);
            
            if(!map.containsKey(sortedStr))
                map.put(sortedStr, new ArrayList<>());
            
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}




Time Complexity - O(n*k) 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs == null || strs.length == 0) 
            return new ArrayList<>();
        
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            char[] count = new char[26];
            
            for(char c : str.toCharArray())
                count[c - 'a']++;
            
            String sortedStr = new String(count);
            
            if(!map.containsKey(sortedStr))
                map.put(sortedStr, new ArrayList<>());
            
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}