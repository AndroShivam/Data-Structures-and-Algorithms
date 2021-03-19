// Brute Force

class LearningDS {
    public static void main(String[] args) {
        int[] nums = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == i){
                System.out.println(i);
                break;
            }
        }
    }
}

// Binary Search (Distinct Elements)

class LearningDS {
    public static void main(String[] args) {
        int[] nums = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};

        int res = magicIndex(nums);
        System.out.println(res);
    }

    private static int magicIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid)
                return mid;
            if (mid > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}


// Binary Search (Duplicates Allowed)

class LearningDS {
    public static void main(String[] args) {
        int[] nums = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};

        int res = magicIndex(nums, 0, nums.length - 1);
        System.out.println(res);
    }

    private static int magicIndex(int[] nums, int start, int end) {
        if (start > end) return -1;

        int midIndex = start + (end - start) / 2;
        int midValue = nums[midIndex];

        if (midIndex == midValue)
            return midIndex;

        int left = magicIndex(nums, start, Math.min(midIndex - 1, nums[midIndex]));

        if (left >= 0) return left;

        return magicIndex(nums, Math.max(midIndex + 1, nums[midIndex]), end);
    }
}