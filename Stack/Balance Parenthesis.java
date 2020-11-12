import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {

        String brackets = "()[]{}[[]]{}";

        boolean isBalanced = checkBalanceParenthesis(brackets, brackets.length());
        System.out.println(isBalanced);
    }

    private static boolean checkBalanceParenthesis(String exp, int n) {
        char[] c = exp.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (c[i] == '{' || c[i] == '[' || c[i] == '(')
                stack.push(c[i]);
            else if (c[i] == '}' || c[i] == ')' || c[i] == ']') {
                if (stack.isEmpty() || !ArePairs(stack.peek(), c[i]))
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean ArePairs(char op, char cl) {
        if (op == '{' && cl == '}')
            return true;
        if (op == '[' && cl == ']')
            return true;
        if (op == '(' && cl == ')')
            return true;

        return false;
    }
}