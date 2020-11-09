class LearningDS {
    public static void main(String[] args) {
        int[] a = {1, 12, 4, 6, 23, 11};


        findSecondLargest(a, a.length);
    }

    private static void findSecondLargest(int[] a, int n) {

        int first_largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] > first_largest) {
                second_largest = first_largest;
                first_largest = a[i];
            } else {
                if (a[i] > second_largest && first_largest != a[i])
                    second_largest = a[i];
            }
        }

        System.out.println("First Largest : " + first_largest + "\n" + "Second Largest : " + second_largest);
    }
}