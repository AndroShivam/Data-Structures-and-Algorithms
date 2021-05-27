// Using List

// Time Complexity - O(N^2)
// Space Complexity - O(N)

class Solution {
    public int singleNonDuplicate(int[] nums) {
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

// Using Xor

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }
}

// Using Binary Search

// Time Complexity - O(LogN)
// Space Complexity - O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(mid % 2 == 0){ // check if first instance of number is at even index 
                if(nums[mid] == nums[mid + 1])
                    low = mid + 2;
                else
                    high = mid;
            }else{ // check if second instance of number is at odd index
                if(nums[mid] == nums[mid - 1])
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        return nums[low];
    }
}