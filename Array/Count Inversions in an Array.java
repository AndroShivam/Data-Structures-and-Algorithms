// Time Complexity - O(N^2)
// Space Complexity - O(1)

class LearningDS{
    public static void main(String[] args) {
        int[] nums = {8,6,4,2};
        int inversionCount = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    inversionCount++;
                }
            }
        }

        System.out.println(inversionCount);
    }
}

// Time Complexity - O(NLogN)
// Space Complexity - O(N)

class LearningDS {
    public static void main(String[] args) {
        int[] nums = {1, 9, 6, 4, 5};

        int inversionCount = mergeSort(nums, 0, nums.length - 1);
        System.out.println(inversionCount);
    }

    private static int mergeSort(int[] nums, int low, int high) {
        int inversionCount = 0;
        if (low < high) {
            int mid = low + (high - low)/2;
            inversionCount += mergeSort(nums, low, mid);
            inversionCount += mergeSort(nums, mid + 1, high);
            inversionCount += merging(nums, low, mid, high);
        }

        return inversionCount;
    }

    private static int merging(int[] nums, int low, int mid, int high) {

        int[] temp = new int[nums.length];

        int i = low;
        int j = mid + 1;
        int k = low;
        int inversionCount = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
                inversionCount += (mid - i + 1);
            }
            k++;
        }

        if (i > mid) {
            while (j <= high)
                temp[k++] = nums[j++];
        } else {
            while (i <= mid)
                temp[k++] = nums[i++];
        }

        for(i=low; i<=high; i++)
            nums[i] = temp[i];

        return inversionCount;
    }
}