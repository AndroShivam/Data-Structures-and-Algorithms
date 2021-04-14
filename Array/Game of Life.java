class Solution {
    private final int[][] dirs = {{1,0},{0,1},{-1,1},{1,-1},{1,1},{-1,-1},{-1,0},{0,-1}};
    private final int STATE_DEAD = 2;
    private final int STATE_LIVE = 3;
    
    private int row;
    private int col;
    public void gameOfLife(int[][] board) {
        row = board.length;
        col = board[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int liveNeighbors = findLiveNeighbors(board, i, j); 
                if(board[i][j] == 0 && liveNeighbors == 3)
                    board[i][j] = STATE_LIVE;
                else if(board[i][j] == 1){
                    if(liveNeighbors == 2 || liveNeighbors == 3)
                        continue;
                    else if(liveNeighbors < 2 || liveNeighbors > 3)
                        board[i][j] = STATE_DEAD;
                }
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == STATE_DEAD)
                    board[i][j] = 0;
                else if(board[i][j] == STATE_LIVE)
                    board[i][j] = 1;
            }
        }
    }
    
    private int findLiveNeighbors(int[][] board, int i, int j){
        int lives = 0;
        
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x < 0 || x >= row || y < 0 || y >= col) continue;
            
            if(board[x][y] == 1 || board[x][y] == STATE_DEAD)
                lives++;
        }
        
        return lives;
    }
}