class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for(int num : nums)
            target += num;
        
        if(target == 0) return nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - target)){
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}

// If it exists an answer, then it means we have a subarray in the middle of original array whose sum is == totalSum - x
// If we want to minimize our operations, then we should maximize the length of the middle subarray.
// full explanation with image - https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array