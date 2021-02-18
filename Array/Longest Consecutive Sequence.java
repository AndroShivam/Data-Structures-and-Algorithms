// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int longestStreak = 0;
        
        for(int num : nums)
            set.add(num);
        
        for(int num : nums){
            if(!set.contains(num - 1)){ // initial num of sequence
                int currentNum = num;
                int currentStreak = 1;
                while(set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}