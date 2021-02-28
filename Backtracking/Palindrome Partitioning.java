class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int start, String s, ArrayList<String> tempList, List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(tempList));
        }else   {
            for(int i = start; i < s.length(); i++){
                 if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(i + 1, s, tempList, result);
                    tempList.remove(tempList.size() - 1);
                 }
             }
        }
    }
    
    private boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}