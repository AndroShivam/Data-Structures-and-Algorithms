import java.util.Arrays;

// Time Complexity - O(N * MLogM) -> traversing O(N), Reordering O(MLogM)
// Space Complexity - O(1)

class LearningDS {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 8, 9, 12, 13};
        int[] nums2 = {3, 4, 7, 10};

        int len1 = nums1.length;

        for(int i=0; i<len1; i++){
            boolean isSwapped = false;
            if(nums1[i] > nums2[0]){
                swap(nums1,nums2,i,0);
                isSwapped = true;
            }
            if(isSwapped)
                Arrays.sort(nums2);
        }

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    private static void swap(int[] nums1, int[] nums2, int i, int j){
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }
}