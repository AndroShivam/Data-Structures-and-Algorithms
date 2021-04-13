// Time Complexity - O(N^2)

class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] result = new int[n];
        
        for(int i=0; i<n; i++)
            result[i] = i + 1;
        
        for(int i=1; i<k; i++)
            reverseList(result, i, n - 1);
        
        return result;
    }
    
    private void reverseList(int[] result, int start, int end){
        while(start < end){
            int temp = result[start];
            result[start++] = result[end];
            result[end--] = temp;
        }
    }
}

// Time Complexity - O(N)

class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] result = new int[n];
        
        int left = 1;
        int right = n;
        
        for(int i=0; i<n; i++){
            if(k % 2 == 0)
                result[i] = left++;
            else
                result[i] = right--;
            
            if(k > 1)
                k--;
        }
        
        return result;
    }
}