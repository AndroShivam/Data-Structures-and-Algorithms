// Time Complexity - O(N^2)

class LearningDS {
    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        calculateSpan(prices, prices.length);

        calculateSpanAlt(prices, prices.length);
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

// Time Complexity - O(N)

class LearningDS {
    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = new int[prices.length];

        calculateSpan(prices, prices.length, span);
    }

    private static void calculateSpan(int[] prices, int n, int[] span) {
        Stack<Integer> stack = new Stack<>();

        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()])
                stack.pop();
            span[i] = stack.isEmpty() ? i + 1 : (i - stack.peek());
            stack.push(i);
        }

        System.out.println(Arrays.toString(span));
    }
}