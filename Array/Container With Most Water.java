// Time Complexity - O(N^2)
// Space Complexity - O(1)

class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int min = Math.min(height[i], height[j]);
                int area = min * (j - i);
                max = Math.max(max, area);
            }
        }
        
        return max;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = minHeight * (right - left);
            maxArea =  Math.max(maxArea, currentArea);
            
            if(height[left] < height[right]){
                 left++;
            }else if(height[left] == height[right]){
                left++;
                right--;
            }else{
                right--;
            }
        }
        
        return maxArea;
    }
}