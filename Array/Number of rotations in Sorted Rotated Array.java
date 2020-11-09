class LearningDS {
    public static void main(String[] args) {

        int[] a = {4, 5, 1, 2, 3};

        int index = countRotations(a, 0, a.length - 1);
        System.out.println(index);
    }

    private static int countRotations(int[] a, int low, int high) {

        int mid = (low + high) / 2;

        if (mid < high && a[mid + 1] < a[mid])
            return (mid + 1);
        if (mid > low && a[mid] < a[mid - 1])
            return mid;

        if (a[high] > a[mid])
            return countRotations(a, low, mid - 1);

        return countRotations(a, mid + 1, high);
    }
}