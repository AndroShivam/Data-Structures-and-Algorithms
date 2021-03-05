class Solution 
{
    int findOnce(int arr[], int n)
    {
        int low = 0;
        int high = n - 1;
        
        if(high == 0){ // only a single number is present
            return arr[high]; 
        }else if(arr[0] != arr[1]){ // first two numbers are not same
            return arr[0];
        }else if(arr[high] != arr[high - 1]){ // last two numbers are not same
            return arr[high];
        }
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){ // adjacent numbers of mid are not same
                return arr[mid];
            }
            
            if((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])){ // duplicate numbers appear on odd and then even index 
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}