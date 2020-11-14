import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pIndex = Partition(a, start, end);
            quickSort(a, start, pIndex - 1);
            quickSort(a, pIndex + 1, end);
        }
    }

    private static int Partition(int[] a, int start, int end) {
        int pivot = a[end]; // take last element as pivot;
        int pIndex = start;
        int temp;

        for (int i = start; i < end; i++) {
            if (a[i] < pivot) { // if a element is less than pivot swap it with pIndex
                temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex++;
            }
        }

        temp = a[pIndex]; // now Pindex points to the correct location of pivot (smaller on the left and larger on the right)
        a[pIndex] = a[end];
        a[end] = temp;

        return pIndex;
    }

    // Output
    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    // Time Complexity = O(nlogn)
}