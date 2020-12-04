class LearningDS {
    static boolean[][] dp;

    public static void main(String[] args) {
        int[] a = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        dp = new boolean[a.length + 1][sum + 1];

        System.out.println(subsetSum(a, sum));
    }

    private static boolean subsetSum(int[] a, int sum) {

        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) // if there is nothing in the array we can not make sum so false
                    dp[i][j] = false;
                else if (j == 0) // if sum is 0 we can have empty subset so true
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