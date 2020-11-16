class LearningDS {
    public static void main(String[] args) {
        int[] a = {10, 15, 20, 12,6, 5, 74, 23};

        int element = findPeak(a, 0, a.length - 1);
        System.out.println(a[element]);
    }

    private static int findPeak(int[] a, int start, int end) {

        int mid = start + (end - start) / 2;

        if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == a.length - 1 || a[mid] >= a[mid + 1]))
            return mid;

        else if (mid > 0 && a[mid - 1] > a[mid])
            return findPeak(a, start, mid - 1);
        else
            return findPeak(a, mid + 1, end);
    }
}