class Solution {
    public String[] findWords(String[] words) {
        Character[] charRow1 = {'q','w','e','r','t','y','u','i','o','p'};
        Character[] charRow2 = {'a','s','d','f','g','h','j','k','l'};
        Character[] charRow3 = {'z','x','c','v','b','n','m'};
        
        Set<Character> row1 = new HashSet<>(Arrays.asList(charRow1));
        Set<Character> row2 = new HashSet<>(Arrays.asList(charRow2));
        Set<Character> row3 = new HashSet<>(Arrays.asList(charRow3));
        
        List<String> result = new ArrayList<>();
        
        for(String word : words){
            if(isValid(row1, word) || isValid(row2, word) || isValid(row3, word))
                result.add(word);
        }
        
        return result.toArray(new String[0]);
    }
    
    private boolean isValid(Set<Character> row, String word){
        for(char c : word.toCharArray()){
            if(!row.contains(Character.toLowerCase(c)))
                return false;
        }
        return true;
    }
}