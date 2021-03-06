// Time Complexity: O(n+k) where n is size of input array and k is the range of input.
// Space Space: O(n+k)

import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 2, 1, 4, 0, 5};
        countingSort(arr, arr.length);
    }

    private static void countingSort(int[] arr, int n) {
        int[] result = new int[n + 1];
        int max = findMax(arr);
        int[] count = new int[max + 1];

        for (int i = 0; i < n; i++)
            ++count[arr[i]];

        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            result[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < n; i++)
            arr[i] = result[i];

        System.out.println(Arrays.toString(arr));

        //  Output - [0, 1, 2, 2, 3, 4, 4, 5]
    }

    private static int findMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        return max;
    }
}



// Counting sort is a linear time sorting algorithm that sort in O(n+k) time when elements are in the range from 1 to k.

// What if the elements are in the range from 1 to n2? 
// We can’t use counting sort because counting sort will take O(n2) which is worse than comparison-based sorting algorithms. Can we sort such an array in linear time? 

// Radix Sort is the answer. The idea of Radix Sort is to do digit by digit sort starting from least significant digit to most significant digit. Radix sort uses counting sort as a subroutine to sort.
