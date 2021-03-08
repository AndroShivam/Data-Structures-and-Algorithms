// Approach 1
// Time Complexity - O(Max(row, col) * row * col)

class Solution {
    public int orangesRotting(int[][] grid) {
        
        boolean changed = false; // at any point if we can't change adjacent oranges return then break;
        int number = 2;
        
        int row = grid.length;
        int col = grid[0].length;
        
        while(true){
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(grid[i][j] == number){
                        if(isSafe(i + 1, j, row, col) && grid[i + 1][j] == 1){
                            grid[i + 1][j] = grid[i][j] + 1;
                            changed = true;
                        }
                        
                        if(isSafe(i, j + 1, row, col) && grid[i][j + 1] == 1){
                            grid[i][j + 1] = grid[i][j] + 1;
                            changed = true;
                        }
                        
                        if(isSafe(i - 1, j, row, col) && grid[i - 1][j] == 1){
                            grid[i - 1][j] = grid[i][j] + 1;
                            changed = true;
                        }
                        
                        if(isSafe(i, j - 1, row, col) && grid[i][j - 1] == 1){
                            grid[i][j - 1] = grid[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }
            
            if(!changed) break;
            
            changed = false;
            number++;
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        
        return number - 2;
    }
    
    private static boolean isSafe(int i, int j, int r, int c){
          return (i >= 0 && i < r && j >= 0 && j < c);
    }
}


// Approach 2
// Time Complexity - O(row * col)

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int countFresh = 0;
        int count = 0;
        
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    countFresh++;
            }
        }
        
        if(countFresh == 0) return count;
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();

            for(int i=0; i<size; i++){
                int[] point = queue.poll();
                
                for(int[] dir : dirs){
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    
                    if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    
                    grid[x][y] = 2;
                    
                    queue.offer(new int[]{x, y});
                    countFresh--;
                }
            }
        }
        
        return countFresh == 0 ? count - 1 : -1;
    }
}