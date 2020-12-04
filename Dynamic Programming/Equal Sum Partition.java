class LearningDS {
    public static void main(String[] args) {

        int[] a = {1, 10, 16, 5};

        // {1,10,5} = {16} this is equal sum partition
        System.out.println(equalSumPartition(a));
    }

    private static boolean equalSumPartition(int[] a) {
        int sum = 0;

        for (int val : a)
            sum += val;

        if (sum % 2 != 0) // if sum is not even we can't divide array into two equal halves
            return false;
        else
            return subsetSum(a, sum / 2); // we know that sum is even if one half is present other half would be too
    }

    private static boolean subsetSum(int[] a, int sum) {
        boolean[][] dp = new boolean[a.length + 1][sum + 1];

        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    dp[i][j] = false;
                else if (j == 0)
                    dp[i][j] = true;
                else if (a[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - a[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[a.length][sum];
    }

}