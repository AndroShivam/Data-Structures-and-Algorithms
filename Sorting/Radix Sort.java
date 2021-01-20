import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr, arr.length);
    }

    private static void radixSort(int[] arr, int n) {
        int max = findMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    private static void countSort(int[] arr, int n, int exp) {
        int[] result = new int[n];
        int[] count = new int[10]; // count will always be between 0 to 9

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            result[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for(int i=0; i<n; i++)
            arr[i] = result[i];

        System.out.println(Arrays.toString(arr));
        
//        Output -
//        [170, 90, 802, 2, 24, 45, 75, 66]
//        [802, 2, 24, 45, 66, 170, 75, 90]
//        [2, 24, 45, 66, 75, 90, 170, 802]
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int element : arr)
            if (element > max)
                max = element;

        return max;
    }
}
