Time: O(max(n2, N)), space: O(N), where n2 = arr2.length, N = max(arr2).

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int[] count = new int[1001];
        int[] res = new int[arr1.length];
        int k = 0;
        
        // add elements of arr1
        for(int num : arr1)
            count[num]++;
        
        // add elements acc to arr2 and decrease count
        for(int num : arr2){
            while(count[num]-- > 0){
                res[k++] = num;
            }
        }
        
        // add remaining acc to ascending order
        for(int i=0; i<count.length; i++){
            while(count[i]-- > 0){
                res[k++] = i;
            }
        }
        
        return res;
    }
}

