// Using Temp Stack

import java.util.Stack;
class LearningDS {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(8);

        sortStack(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp)
                stack.push(tempStack.pop());

            tempStack.push(temp);
        }
        System.out.println(tempStack);
    }
}

// Using Recursion

import java.util.Stack;
class LearningDS {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(8);

        System.out.println("Before Sorting : " + stack);
        sortStack(stack);
        System.out.println("After Sorting : " + stack);

    }

    private static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int x = stack.pop();

        sortStack(stack);

        sortedInsert(stack, x);
    }

    private static void sortedInsert(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
            return;
        }

        int temp = stack.pop();
        sortedInsert(stack, x);

        stack.push(temp);
    }
}