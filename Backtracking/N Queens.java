class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        char[][] board = new char[n][n];
        
        for(char[] cell : board)
            Arrays.fill(cell, '.');
        
        solveNQueensUtil(board, 0, result);
        
        return result;
    }
    
    private void solveNQueensUtil(char[][] board, int colIndex, List<List<String>> result){
        if(colIndex == board.length){ // all queens are placed
            result.add(construct(board));
            return;
        }
        
        for(int i=0; i<board.length; i++){
            if(isSafe(board, i, colIndex)){
                board[i][colIndex] = 'Q';
                solveNQueensUtil(board, colIndex + 1, result);
                board[i][colIndex] = '.'; // backtrack
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col){
        int i, j; 
  
        /* Check this row on left side */
        for (i = 0; i < col; i++) 
            if (board[row][i] == 'Q') 
                return false; 
  
        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 'Q') 
                return false; 
  
        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) 
            if (board[i][j] == 'Q') 
                return false; 
  
        return true; 
    }
    
    
    private List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        
        return res;
    }
}