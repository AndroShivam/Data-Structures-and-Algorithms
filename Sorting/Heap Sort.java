import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {

        int[] arr = {2, 8, 5, 3, 9, 1};

        heapSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, int n) {

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) { // each time largest will be in its exact position
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0); // max heap on the reduced heap
        }
    }

    private static void heapify(int[] a, int n, int i) {

        int largest = i;
        int left = 2 * i + 1; // left element of largest (assumed)
        int right = 2 * i + 2; // right element of largest

        if (left < n && a[left] > a[largest]) // if left is largest then set it to largest
            largest = left;

        if (right < n && a[right] > a[largest]) // if right is largest then set it to largest
            largest = right;

        if (largest != i) { // if largest has been changed swap it to the assumed largest in the beginning
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest); // heapify on the subtree
        }
    }
}