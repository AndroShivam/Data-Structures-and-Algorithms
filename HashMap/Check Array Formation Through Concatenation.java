// Time Complexity - O(NK), where k is the avg length of 1D array
// Space Complexity - O(N)

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int[] piece : pieces)
            map.put(piece[0], piece);
        
        int[] result = new int[arr.length];
        int index = 0;
        
        for(int num : arr){
            if(map.containsKey(num)){
                for(int n : map.get(num))
                    result[index++] = n;
            }
        }
        
        return Arrays.equals(arr, result);
    }
}