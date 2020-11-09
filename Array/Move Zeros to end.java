import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {

        int[] a = {1, 2, 0, 9, 1, 0, 12, 100, 43, 0, 8};
        int n = a.length;

        moveAllZeros(a, n);
        System.out.println(Arrays.toString(a));
    }

    private static void moveAllZeros(int[] a, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                a[count++] = a[i];
            }
        }

        while (count < n) {
            a[count++] = 0;
        }
    }
}