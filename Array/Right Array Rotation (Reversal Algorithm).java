import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {

        /*
         *  Given array = {1,2,3,4,5} and numOfRotations = 2
         *  if we rotate from 0 to numOfRotations - 1
         *  and from numOfRotations to n - 1
         *  and then whole array we get the desired output
         *
         *  Example -
         *  {1,2,3,4,5}
         *  0 to numOfRotations -> {2,1,3,4,5}
         *  numOfRotations to n - 1 -> {2,1,5,4,3}
         *  whole array -> {3,4,5,1,2}
         * */

        int[] a = {1, 2, 3, 4, 5};
        int numOfRotations = 2;

        reversalAlgorithm(a, numOfRotations);

        // Printing Array
        System.out.println(Arrays.toString(a));
    }

    private static void reversalAlgorithm(int[] a, int numOfRotations) {
        if (numOfRotations == 0)
            return;

        reverseArray(a, 0, numOfRotations - 1);
        reverseArray(a, numOfRotations + 1, a.length - 1);
        reverseArray(a, 0, a.length - 1);
    }

    private static void reverseArray(int[] a, int start, int end) {
        int temp;
        while (start <= end) {
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }
}