class Solution {
    int row, col;
    public boolean exist(char[][] board, String word) {
        
        char[] w = word.toCharArray();
        row = board.length;
        col = board[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(exist(board, w, i, j, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, char[] word, int i, int j, int index){
        if(index == word.length) return true;
        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] != word[index]) return false;
        
        board[i][j] = '0';
        
        boolean result  = exist(board, word, i + 1, j, index + 1)
            || exist(board, word, i - 1, j, index + 1)
            || exist(board, word, i, j + 1, index + 1)
            || exist(board, word, i, j - 1, index + 1);
        
        board[i][j] = word[index]; // backtrack
        
        return result;
    }
}