// Time Complexity - O(N^2)

class Solution {
    public int diagonalSum(int[][] mat) {
        
        int res = 0;
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(i == j)
                    res += mat[i][j];
                else if((i + j) == (mat.length - 1))
                    res += mat[i][j];
            }
        }  
        return res;
    }
}

// Time Complexity - O(N)

class Solution {
    public int diagonalSum(int[][] mat) {
        
        int res = 0;
        int n = mat.length;
        
        for(int i=0; i<n; i++){
            res += mat[i][i]; // Primary diagonals are row = column! 
            res += mat[i][n - i - 1]; // Secondary diagonals are row + column = n-1!
        }
        
        return n % 2 == 0 ? res : res - mat[n/2][n/2]; // if n is a odd number, that mean we have added the center element twice!
    }
}