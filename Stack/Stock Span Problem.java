import java.util.Arrays;
import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {

        /* 100 80 60 70 60 75 85
           select a number and scan on its left side increase count till we get number bigger than it
           there's nothing in the left of 100 so its span is 0
           80 >= 100 is false so span is 1
           60 >= 80 is false so span is 1
           70 >= 60 so span is 2
           85 > 75 > 60 > 70 > 60 > 80 hence span is 6
        */

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        calculateSpan(prices, prices.length);

        calculateSpanAlt(prices, prices.length);
    }

    private static void calculateSpanAlt(int[] prices, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                span[i] = 1;
            } else if (stack.peek() > prices[i])
                span[i] = 1;
            else {
                while (!stack.isEmpty() && stack.peek() < prices[i]) {
                    stack.pop();
                    count++;
                }
                span[i] = count;
            }
            stack.push(prices[i]);
        }

        System.out.println(Arrays.toString(span));
    }

    private static void calculateSpan(int[] prices, int n) {
        int[] span = new int[prices.length];
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            span[i] = 1;
            for (int j = i - 1; j >= 0 && (prices[i] >= prices[j]); j--)
                span[i]++;
        }

        System.out.println(Arrays.toString(span));
    }
}

// Output
//[1, 1, 1, 2, 1, 4, 6]