// Recursive 

class Solution {
    private static final String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        
        if(digits.isEmpty())
            return new ArrayList<String>();
        
        ArrayList<String> result = new ArrayList<>();
        helper(digits, result, 0, "");
        return result;
    }
    
    private void helper(String digits, ArrayList<String> result, int index, String prefix){
        if(index == digits.length()){
            result.add(prefix);
            return;
        }
        
        char[] letters = mapping[digits.charAt(index) - '0'].toCharArray();
        
        if(letters.length != 0){
            for(char letter : letters)
                helper(digits, result, index + 1, prefix + letter);
        }
    }
}

// Iterative

class Solution {
    public List<String> letterCombinations(String digits) {
        
        LinkedList<String> result = new LinkedList<>();
        if(digits.isEmpty())
            return result;
        
        String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        result.add("");
        
        for(int i=0; i<digits.length(); i++){
            int digit = Character.getNumericValue(digits.charAt(i)); // convert char to int
            
            while(result.peek().length() == i){
                String t = result.remove();
                
                for(char c : mapping[digit].toCharArray())
                    result.add(t + c);
            }
        }
        
        return result;
    }
}