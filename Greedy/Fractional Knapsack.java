import java.util.Arrays;

class ItemValue {
    Double cost; // declared using Wrapper class because we'll be using compareTo() method
    double wt, val;

    public ItemValue(int wt, int val) {
        this.wt = wt;
        this.val = val;
        this.cost = ((double) val / (double) wt);
    }
}

class LearningDS {
    public static void main(String[] args) {
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        double profit = fractionalKnapsack(wt, val, capacity);
        System.out.println(profit);
    }

    private static double fractionalKnapsack(int[] wt, int[] val, int capacity) {
        ItemValue[] itemValue = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            itemValue[i] = new ItemValue(wt[i], val[i]);
        }

        Arrays.sort(itemValue, (a, b) -> b.cost.compareTo(a.cost)); // sort according to cost

        int currentWeight = 0;
        double totalProfit = 0.0;

        for (int i = 0; i < wt.length; i++) {
            if (currentWeight + itemValue[i].wt <= capacity) {
                currentWeight += itemValue[i].wt;
                totalProfit += itemValue[i].val;
            } else {
                int remain = capacity - currentWeight;
                totalProfit += (itemValue[i].val / itemValue[i].wt) * (double) remain;
                break; // bag is full
            }
        }

        return totalProfit;
    }
}

