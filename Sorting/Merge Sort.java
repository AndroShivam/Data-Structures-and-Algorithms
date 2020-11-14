import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    private static void mergeSort(int[] a, int low, int high) {

        if (low < high) {
            int mid = low + (high - low) / 2; // to prevent integer overflow

            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merging(a, low, mid, high);
        }
    }

    private static void merging(int[] a, int low, int mid, int high) {
        int[] helper = new int[a.length];

        for (int i = low; i <= high; i++)
            helper[i] = a[i];

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;


        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                a[current] = helper[helperLeft]; // add smaller to array
                helperLeft++;
            } else {
                a[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        if (helperLeft > mid) { // if helperright has some element left

            while (helperRight <= high) {
                a[current] = helper[helperRight];
                helperRight++;
                current++;
            }
        } else { // if helperleft has some elements left
            while (helperLeft <= mid) {
                a[current] = helper[helperLeft];
                helperLeft++;
                current++;
            }
        }
    }

    // Output
    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    // Time Complexity = O(nlogn)
}