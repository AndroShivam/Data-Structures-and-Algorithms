class GFG
{
    static void rotate(int matrix[][]) 
    {
        // Code Here
        
        int n = matrix.length;
        
        
        // transponse matrix
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // swap first and last element of column
        for(int i=0; i<n; i++){
            for(int j=0, k = n - 1; j<k; j++,k--){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
    }
}