class LearningDS {
    public static void main(String[] args) {

        // count number of subsets with a given difference
        // sum(s1) - sum(s2) = diff
        // sum(s1) + sum(s2) = sum of array
        // adding these equations
        // 2 * sum(s1) = diff + sum of array
        // sum(s1) = (diff + sum of array)/2

        int[] a = {1, 1, 2, 3};
        int diff = 1;


        int count = countSubsetWithGivenDiff(a, diff);
        System.out.println(count);

    }

    private static int countSubsetWithGivenDiff(int[] a, int diff) {

        int sum = 0;
        for (int val : a)
            sum += val;

        int sum_s1 = (diff + sum) / 2;

        return countSubsetSum(a, sum_s1);
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