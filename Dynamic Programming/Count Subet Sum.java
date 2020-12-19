class LearningDS {
    public static void main(String[] args) {

        int[] a = {2, 3, 5, 6, 8, 10};
        int sum = 10;

        int count = countSubsetSum(a, sum);
        System.out.println(count);
    }

    private static int countSubsetSum(int[] a, int sum) {

        int[][] dp = new int[a.length + 1][sum + 1];

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (a[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - a[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[a.length][sum];
    }
}