// Time Complexity - O(NLogN)
// Space Complexity - O(1)

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)

class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int num : nums){
            if(map.get(num) > Math.floor(nums.length / 2.0))
                result = num;
        }
        
        return result;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int element = 0;
        
        for(int num : nums){
            if(count == 0)
                element = num;
            if(num != element)
                count--;
            else
                count++;
        }     
        return element;
    }
}

/*

Explanation - Moore's Voting Algorithm

[2,2,1,1,1,2,2]

we know that there always exist a number that appears greater than n/2

[2] -> element = 2, count = 1
[2,2] -> element = 2, count = 2
[2,2,1] -> element = 2, count = 1
[2,2,1,1] -> element = 2, count = 0 // here we know that 2 and 1 appears same number of time so we can't say which one is the majority element
[2,2,1,1,1] -> element = 1, count = 1
[2,2,1,1,1,2] -> element = 1, count = 0
[2,2,1,1,1,2,2] -> element = 2, count = 1


[2,2,1,1] -> cancel out each other
[1,2] -> again cancel out each other
[2] -> majority element

*/