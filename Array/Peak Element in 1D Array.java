class LearningDS {
    public static void main(String[] args) {

        /*
         * a[i] is said to be peak element if its greater than its adjacent elements
         * i.e a[i - 1] <= a[i] >= a[i + 1]
         *
         * Elements at ends (i == 0 and i == n- 1) have only one adjacent element so one comparison
         * */

        int[] a = {12, 43, 6, 24, 4, 6, 56};


        int peakElement = findPeak(a, 0, a.length - 1);
        System.out.println(peakElement);
    }

    private static int findPeak(int[] a, int low, int high) {

        int mid = (low + high) / 2;

        /*
        *  mid = 0 means its the first element and it sees if a[mid] >= a[mid + 1] if true its a peak
        *  similarly a[mid] >= a[mid - 1] and mid == a.length - 1 goes together
        * */


        if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == a.length - 1 || a[mid] >= a[mid + 1]))
            return a[mid];

        /* here's a interesting case
           if a[mid - 1] > a[mid] means if a[mid - 1] is also greater than a[mid - 2] it can be a peak element
           hence we recursively check from low to mid - 1
        */
        else if (mid > 0 && a[mid - 1] > a[mid])
            return findPeak(a, low, mid - 1);

        /* else if a[mid + 1] > a[mid]
           if a[mid + 1] is also greater than a[mid + 2]
           it can be a peak element
           hence we recursively check for mid + 1 to high
        * */
        else
            return findPeak(a, mid + 1, high);


    }
}