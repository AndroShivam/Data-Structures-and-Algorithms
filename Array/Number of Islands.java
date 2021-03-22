// DFS

class Solution {
    private int row, col;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1')
            return;
        
        grid[i][j] = '0'; // mark visited
        
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

// BFS

class Solution {
    private int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    private int row, col;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    queue.offer(new int[]{i, j});
                    bfs(grid, queue);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfs(char[][] grid, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int[] dir : dirs){
                int x = dir[0] + current[0];
                int y = dir[1] + current[1];
                
                if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') continue;
                
                grid[x][y] = '0';
                
                queue.offer(new int[] {x, y});
            }
        }
    }
}