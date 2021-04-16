// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr == null || arr.length < 3) return false;
        
        boolean increasing = arr[1] > arr[0];
        
        if(!increasing) return false;
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i - 1]) return false;
            
            if(increasing){
                if(arr[i] < arr[i - 1])
                    increasing = false;
            }else{
                if(arr[i] > arr[i - 1])
                    return false;
            }
        }
        
        return !increasing;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr == null || arr.length < 3) return false;
        
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end){
            if(arr[start + 1] > arr[start])
                start++;
            else if(arr[end - 1] > arr[end])
                end--;
            else
                break;
        }
        
        return start != 0 && end != arr.length - 1 && start == end;
    }
}