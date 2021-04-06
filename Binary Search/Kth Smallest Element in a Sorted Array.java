// Binary Search

// Time Complexity - O(N∗log(max−min))
// Space Complexity - O(1)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        
        int low = matrix[0][0]; // smallest element
        int high = matrix[n - 1][n - 1]; // largest element
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            int count = count(matrix, n, mid);
            
            if(k > count)
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }
    
    private int count(int[][] matrix, int n, int mid){
        int count = 0;
        int j = n - 1; // will point to top right corner
        
        for(int i=0; i<n; i++){
            while(j >= 0 && matrix[i][j] > mid) // decrease column if value is greater than mid
                j--;
            
            // if element at current column is less than mid then every element in lower column(same row) will be less than mid
            count += j + 1; 
        }
        
        return count;
    }
}