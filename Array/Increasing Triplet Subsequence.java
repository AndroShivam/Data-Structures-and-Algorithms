// Time Complexity - O(N^3)
// Space Complexity - O(1)

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i] < nums[j] && nums[j] < nums[k])
                        return true;
                }
            }
        }
        
        return false;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int num : nums){
            if(min >= num)
                min = num;
            else if(secondMin > num)
                secondMin = num;
            else if(num > secondMin)
                return true;
        }
        
        return false;
    }
}

// The main idea is keep two values when check all elements in the array: the minimum value min until now 
// and the second minimum value secondMin from the minimum value's position until now. 
// Then if we can find the third one that larger than those two values at the same time, 
// it must exists the triplet subsequence and return true.

// What need to be careful is: we need to include the condition that some value has the same value with minimum number, 
// otherwise this condition will cause the secondMin change its value.

// credits : @yunzeLi on leetcode.com