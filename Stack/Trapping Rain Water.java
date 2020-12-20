// Time Complexity O(N) and Space Complexity O(1)

class Solution {
    public int trap(int[] height) {
        
        if(height.length <= 2)
            return 0;
        
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMaxHeight = height[0];
        int rightMaxHeight = height[n - 1];
        int totalArea = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                leftMaxHeight = Math.max(leftMaxHeight, height[++left]);
                totalArea += leftMaxHeight - height[left];
            }else{
                rightMaxHeight = Math.max(rightMaxHeight, height[--right]);
                totalArea += rightMaxHeight - height[right];
            }
        }
        
        return totalArea;
        
    }
}




// Same Approach but with Space Complexity - O(N)
class Solution {
    public int trap(int[] height) {
        
        if(height.length <= 2)
            return 0;
        
        int n = height.length;
        int[] maxRight = new int[n];
        int[] maxLeft = new int[n];
        
        maxRight[0] = height[0];
        
        for(int i=1; i<n; i++)
            maxRight[i] = Math.max(height[i], maxRight[i - 1]);
        
        maxLeft[n - 1] = height[n - 1];
        
        for(int i = n - 2; i>=0; i--)
            maxLeft[i] = Math.max(height[i], maxLeft[i + 1]);
        
        int result = 0;
        for(int i=0; i<n; i++)
            result += Math.min(maxRight[i], maxLeft[i]) - height[i];
        
        return result;
    }
}