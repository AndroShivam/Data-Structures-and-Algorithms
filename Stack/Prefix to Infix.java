import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {

        /*
        * Scan from right to left
        * if operand push onto the stack
        * if operator pop two operands and convert to infix
        * */

        String prefix = "*-A/BC-/AKL";

        String infixExpression = prefixToInfix(prefix, prefix.length());
        System.out.println(infixExpression);
    }

    private static String prefixToInfix(String prefix, int n) {
        Stack<String> st = new Stack<>();
        char[] e = prefix.toCharArray();

        for (int i = n - 1; i >= 0; i--) {

            if (isOperator(e[i])) {
                String op1 = st.pop();
                String op2 = st.pop();

                String result = "(" + op1 + e[i] + op2 + ")";
                st.push(result);
            } else {
                st.push(String.valueOf(e[i]));
            }
        }

        return st.peek();
    }

    private static boolean isOperator(char c) {
        switch (c) {
            case '^':
            case '+':
            case '-':
            case '/':
            case '*':

                return true;
        }
        return false;
    }
}