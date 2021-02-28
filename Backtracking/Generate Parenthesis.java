class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("",n,n,result);
        return result;
    }
    
    private void backtrack(String str, int open, int close, List<String> result){
        if(open == 0 && close == 0){
            result.add(str);
            return;
        }
        
        if(open != 0)
            backtrack(str + "(", open - 1, close, result);
        
        if(close > open)
            backtrack(str + ")", open, close - 1, result);
    }
}



/*

Explanation 

for n = 2 // (()), ()()

open = 2, close = 2

we can only choose open first 

first call

"(" -> open = 1, close = 2

second call

"((" -> open = 0, close = 2

third call 

"(()" -> open = 0, close = 1

fourth call 

"(())" -> open = 0, close = 0  -> add to result


backtrack to first call

"(" -> open = 1, close = 2

close > open

"()" -> open = 1, close = 1

open != 0

"()(" -> open = 0, close = 1

close > open

"()()" -> open = 0, close = 0   -> add to result

*/