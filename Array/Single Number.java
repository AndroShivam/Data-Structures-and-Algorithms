// Time Complexity - O(N^2) // list.contains() takes O(N) complexity
// Space Complexity - O(N)

class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int num : nums){
            if(!list.contains(num))
                list.add(num);
            else
                list.remove(new Integer(num)); 
        }
        
        return list.get(0);
    }
}

// Time Complexity - O(N) 
// Space Complexity - O(N)


class Solution {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> hashTable = new HashMap<>();
        
        for(int num : nums)
            hashTable.put(num, hashTable.getOrDefault(num, 0) + 1);
        
        for(int num : nums){
            if(hashTable.get(num) == 1)
                return num;
        }
        
        
        return 0;
    }
}

// Time Complexity - O(N) 
// Space Complexity - O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for(int num : nums)
            res ^= num;
        
        return res;
    }
}

/*
EXPLANATION

Xor of two numbers cancel out each other
Note - Xor with 0 returns number itself
e.g 
4 ->   0 1 0 0 
4 ->   0 1 0 0
res -> 0 0 0 0

so, the single number won't be cancel out 
*/