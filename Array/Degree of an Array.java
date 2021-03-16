// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>()
            , count = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(left.get(num) == null) left.put(num, i);
            right.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for(int x : count.keySet()){
            if(count.get(x) == degree){
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        
        return ans;
    }
}