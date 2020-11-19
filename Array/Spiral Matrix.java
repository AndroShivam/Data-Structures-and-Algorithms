class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
     
        List<Integer> list = new ArrayList<>();
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length -1 ;
        int dir = 0;
        
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i<=right; i++)
                    list.add(matrix[top][i]);
                top++;
            }
            if(dir == 1){
                for(int i=top; i<=bottom; i++)
                    list.add(matrix[i][right]);
                right--;
            }
            if(dir == 2){
                for(int i=right; i>=left; i--)
                    list.add(matrix[bottom][i]);
                bottom--;
            }
            if(dir == 3){
                for(int i=bottom; i>=top; i--)
                    list.add(matrix[i][left]);
                left++;
            }
            
            dir = (dir + 1) % 4;
        }
        return list;
    }
}