import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {

        String postfix = "abc++";

        String infixExpression = postfixToInfix(postfix, postfix.length());
        System.out.println(infixExpression);
    }

    private static String postfixToInfix(String postfix, int n) {

        Stack<String> st = new Stack<>();
        char[] e = postfix.toCharArray();

        for (int i = 0; i < n; i++) {
            if (isOperator(e[i])) {
                String op2 = st.pop();
                String op1 = st.pop();

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