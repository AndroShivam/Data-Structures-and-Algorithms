// Time Complexity - O(NLogN)
// Space Complexity - O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=1; i<nums.length; i++)
            if(nums[i - 1] == nums[i])
                return nums[i];
        
        return -1;
    }    
}

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int findDuplicate(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        for(int num : nums)
            if(map.get(num) >= 2)
                return num;
        
        return -1;
    }    
}


// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}