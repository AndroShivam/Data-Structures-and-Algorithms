// Time Complexity - O(N^2)
// Space Complexity - O(1)

class LearningDS {
    public static void main(String[] args) {
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        int maxLen = 0;

        for(int i=0; i<nums.length; i++){
            int currentSum = 0;
            for(int j=i; j<nums.length; j++){
                currentSum += nums[j];
                if(currentSum == 0){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        System.out.println(maxLen);
    }
}

// Time Complexity - O(NLogN)
// Space Complexity - O(N)

import java.util.*;

class LearningDS {
    public static void main(String[] args) {
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) // if every num cancelled out each other so the whole array is the maximum subarray
                maxLen = i + 1;
            else{
                if(map.get(sum) != null)
                    maxLen = Math.max(maxLen, i - map.get(sum));
                else
                    map.put(sum, i);
            }
        }

        System.out.println(maxLen);
    }
}
