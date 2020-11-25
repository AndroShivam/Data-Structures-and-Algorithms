class LearningDS {
    static int[][] dp;

    public static void main(String[] args) {
        int[] items = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int maxCapacity = 50;

        dp = new int[items.length + 1][maxCapacity + 1]; // + 1 because we will manually initialise first row and column of the matrix

        System.out.println(knapsack(items, weight, maxCapacity, items.length));
    }

    private static int knapsack(int[] items, int[] weight, int maxCapacity, int n) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxCapacity; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (weight[i - 1] <= j)
                    dp[i][j] = Math.max(items[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][maxCapacity];
    }
}