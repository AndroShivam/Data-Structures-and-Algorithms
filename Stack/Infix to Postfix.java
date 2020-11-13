import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {

        String infix = "a+b*(c^d-e)^(f+g^h)-i";

        StringBuilder postfix = infixToPostfix(infix, infix.length());
        System.out.println("Postfix : " + postfix);

        // Output
        // Postfix : abcd^e-fgh^+^*+i-
    }

    private static StringBuilder infixToPostfix(String infix, int n) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < n; i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());

                if (!stack.isEmpty() && stack.peek() != '(')
                    return new StringBuilder("Invalid Expression");
                else
                    stack.pop();
            } else { // if c is a operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (stack.peek() == '(')
                        return new StringBuilder("Invalid Expression");

                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result.append(stack.pop());

        return result;
    }

    private static int precedence(int operator) {
        if (operator == '^')
            return 3;
        if (operator == '*' || operator == '/')
            return 2;
        if (operator == '+' || operator == '-')
            return 1;

        return -1;
    }
}