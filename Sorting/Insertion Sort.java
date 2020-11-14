import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};

        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void insertionSort(int[] a, int n) {


        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i - 1;

            while (j >= 0 && temp < a[j]){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    // Output
    // [1, 2, 3, 4, 5]

    // Time Complexity - O(n^2)
}