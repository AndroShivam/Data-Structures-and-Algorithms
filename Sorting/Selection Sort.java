import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};

        selectionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void selectionSort(int[] a, int n) {

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j])
                    minIndex = j;
            }
            int temp = a[minIndex]; // replace ith element with minimum element
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    // Output - [1, 2, 3, 4, 5]
    // Time Complexity - O(n^2)
}