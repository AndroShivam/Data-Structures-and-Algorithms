import java.util.Arrays;

class LearningDS {
    public static void main(String[] args) {

        /*
        * In this Algorithm instead of moving element one by one
        * We make set of elements and move them to their respective positions
        * number of sets = gcd(a.length, numOfRotations)
        *
        * this youtube video explains it really well
        * https://www.youtube.com/watch?v=utE_1ppU5DY
        *
        * */


        int[] a = {1, 2, 3, 4, 5};
        int numOfRotations = 3;


        jugglingAlgorithm(a, a.length, numOfRotations);

        // Printing Array
        System.out.println(Arrays.toString(a));
    }

    private static void jugglingAlgorithm(int[] a, int n, int numOfRotations) {

        for (int i = 0; i < gcd(n, numOfRotations); i++) {
            int temp = a[i]; // store the ith element in temp
            int j = i; // j is the current position where element will be copied

            while(true){
                int step = (j + numOfRotations) % n; // goto the position of element which is to be copied in jth position and "% n" is for circular rotation

                if(step == i) // if we reach i again (circularly) then stop;
                    break;

                a[j] = a[step]; // copy value to jth position
                j = step; // now j points to the copied element's position
            }
            a[j] = temp; // copy initial value to i to a[j]
        }
    }



    /* this function is implementation of Euclidian Algorithm: GCD
    * Read More about it here :
    * https://www.freecodecamp.org/news/euclidian-gcd-algorithm-greatest-common-divisor/
    * */

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else
            return gcd(b % a, a);
    }
}