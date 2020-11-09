import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};

        reverseArray(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void reverseArray(int[] a, int n) {

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}