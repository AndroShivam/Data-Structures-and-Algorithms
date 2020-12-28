import java.util.ArrayList;
import java.util.List;

class LearningDS {
    public static void main(String[] args) {

        // find two subsets whose sum is minimum {1, 6, 5} - {11} = 1
        // this is the minimum subset sum difference
        // In equal sum partition we had s1 - s2 = 0
        // In this we want s1 - s2 = min

        int[] a = {1, 2, 7};

        Integer minDiff = minSubsetSumDiff(a);
        System.out.println(minDiff);
    }

    private static Integer minSubsetSumDiff(int[] a) {

        int sum = 0;
        for (int val : a) sum += val;

        List<Integer> list = subsetSum(a, sum);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++)
            min = Math.min(min, sum - 2 * list.get(i));

        return min;
    }

    private static List<Integer> subsetSum(int[] a, int sum) {

        boolean[][] dp = new boolean[a.length + 1][sum + 1];

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }


        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (a[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - a[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= sum / 2; i++)
            if (dp[a.length][i])
                list.add(i);

        return list;
    }
}