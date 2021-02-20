// Using Brute Force

// Time Complexity - O(N^2)
// Space Complexity - O(N)

class LearningDS {
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 4, 7, 3, 9, 7};
        int n = nums.length;

        boolean[] mark = new boolean[n];
        Arrays.fill(mark, true);

        for (int i = 0; i < n; i++) {
            if (mark[i]) {
                for (int j = i + 1; j < n; j++) {
                    if(nums[i] == nums[j])
                        mark[j] = false; // we won't visit this in the end
                }
            }
        }

        for(int i=0; i<n; i++){
            if(mark[i]){
                System.out.print(nums[i] + " ");
            }
        }
    }
}

// Using Sorting

// Time Complexity - O(NLogN)
// Space Complexity - O(1)

class LearningDS {
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 4, 7, 3, 9, 7};
        int n = nums.length;

        Arrays.sort(nums);
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i];
            }
        }

        nums[j++] = nums[n - 1];

        for(int i=0; i<j; i++)
            System.out.print(nums[i] + " ");
    }
}

// Using HashMap

// Time Complexity - O(N)
// Space Complexity - O(N)

class LearningDS {
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 4, 7, 3, 9, 7};
        int n = nums.length;

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                System.out.print(nums[i] + " ");
            }

            map.put(nums[i], true);
        }
    }
}