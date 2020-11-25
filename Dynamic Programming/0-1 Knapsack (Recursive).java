class LearningDS {
    public static void main(String[] args) {
        int[] items = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int maxCapacity = 50;
        int n = items.length;

        int maxProfit = knapsack(items, weight, maxCapacity, n);
        System.out.println(maxProfit);
    }

    private static int knapsack(int[] items, int[] weight, int maxCapacity, int n) {
        if (n == 0 || maxCapacity == 0) // if there are no items (n == 0) or maxCapacity of bag (maxCapacity == 0) then profit is also 0
            return 0;

        if (weight[n - 1] > maxCapacity)  // weight of item is more than capacity
            return knapsack(items, weight, maxCapacity, n - 1); // so ignore the item
        else // Which gives max profit either accept the item (subtract weight of item from maxCapacity) or neglecting the item
            return Math.max(items[n - 1] + knapsack(items, weight, maxCapacity - weight[n - 1], n - 1), knapsack(items, weight, maxCapacity, n - 1));
    }
}