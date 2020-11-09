import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int numOfRotations = 2;


        for (int i = 0; i < numOfRotations; i++) {
            int temp = a[0]; // for each rotation we store first element of the array to temp variable

            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1]; // we shift every element to its left
            }

            /* as the last element is shifted and at a.length - 2 position
             we can safely copy temp value to a[a.length - 1]
             (-1 because array index starts from 0) */

            a[a.length - 1] = temp;
        }


        System.out.println(Arrays.toString(a));

        // Time Complexity - O(n * numOfRotations)
        // Space Complexity - O(1) (As this algo is inplace)
    }

}