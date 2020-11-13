import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {
        int[] a = {13, 7, 6, 12, 10};

        // Naive Approach O(N2) Complexity
        NGE(a, a.length);

        // Efficient Approach Using Stacks
        NGEUsingStack(a, a.length);
    }

    private static void NGE(int[] a, int n) {
        int next;
        for (int i = 0; i < n; i++) {
            next = -1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] < a[j]) {
                    next = a[j];
                    break;
                }
            }
            System.out.println(a[i] + " -> " + next);
        }
    }

    private static void NGEUsingStack(int[] a, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty())
                res[i] = -1;
            else if (stack.peek() > a[i])
                res[i] = stack.peek();
            else {
                while (!stack.isEmpty() && stack.peek() <= a[i])
                    stack.pop();

                if (stack.isEmpty()) // if first condition terminated the while loop
                    res[i] = -1;
                else // if second condition terminated the while loop
                    res[i] = stack.peek();
            }

            stack.push(a[i]);
        }


        for(int i=0; i<n; i++)
            System.out.println(a[i] + " -> " + res[i]);
    }
}


// Output :- 
// 13 -> -1
// 7 -> 12
// 6 -> 12
// 12 -> -1
// 10 -> -1