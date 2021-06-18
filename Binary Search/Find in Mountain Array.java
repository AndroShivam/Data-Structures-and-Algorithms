/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        MountainArray arr = mountainArr;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr.get(mid) < arr.get(mid + 1))
                left = mid + 1;
            else
                right = mid;
        }
        
        int peak = right;
        
        // binary search on increasing subarray
        
        left = 0;
        right = peak;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target > arr.get(mid))
                left = mid + 1;
            else if(target < arr.get(mid))
                right = mid - 1;
            else
                return mid;
        }
        
        // binary search on decreasing subarray
        
        left = peak;
        right = arr.length() - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target > arr.get(mid))
                right = mid - 1;
            else if(target < arr.get(mid))
                left = mid + 1;
            else
                return mid;
        }
        
        return -1;
    }
}