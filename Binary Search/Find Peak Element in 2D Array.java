class LearningDS {
    public static void main(String[] args) {


        int[][] a = {{10, 8, 10, 10},
                {14, 13, 12, 11},
                {15, 9, 11, 21},
                {16, 17, 1, 20}};

        int rows = a.length;
        int columns = a[0].length;

        int result = findPeek(a, rows, columns, columns / 2);
        System.out.println(result);
    }

    private static int findMax(int[][] a, int rows, int mid, int max) {
        int max_index = 0;
        for (int i = 0; i < rows; i++) {
            if (a[i][mid] > max) {
                max = a[i][mid];
                max_index = i;
            }
        }
        return max_index;
    }

    private static int findMaxElement(int[][] a, int rows, int mid, int max) {
        for (int i = 0; i < rows; i++) {
            if (a[i][mid] > max) {
                max = a[i][mid];
            }
        }
        return max;
    }

    private static int findPeek(int[][] a, int rows, int columns, int mid) {
        int max = findMaxElement(a, rows, mid, 0);
        int max_index = findMax(a, rows, mid, max);

        if (mid == 0 || mid == columns - 1)
            return max;

        if (max >= a[max_index][mid - 1] && max >= a[max_index][mid + 1])
            return max;

        if (max < a[max_index][mid - 1])
            return findPeek(a, rows, columns, (int) (mid - Math.ceil((double) mid / 2)));
        else
            return findPeek(a, rows, columns, (int) (mid - Math.ceil((double) mid / 2)));
    }


}