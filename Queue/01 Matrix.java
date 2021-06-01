// Time Complexity - O(N*M)
// Space Complexity - O(N*M)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[] dir : dirs){
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                
                if(x < 0 || x >= row || y < 0 || y >= col || visited[x][y])
                    continue;
                
                visited[x][y] = true;
                mat[x][y] = mat[current[0]][current[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
        
        return mat;
    }
}