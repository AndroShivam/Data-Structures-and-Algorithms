import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {

        int[] a = {5, 4, 3, 2, 1};

        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


    // Output
    // [1, 2, 3, 4, 5]


    // Time Complexity = O(n^2)
}