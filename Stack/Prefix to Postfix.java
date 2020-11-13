import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {
		
		
        /*
        scan from right to left
        if operand push onto the stack
        if operator pop two elements and use format op1 op2 operator
        */

        String prefix = "*+AB-CD";

        String postfixExpression = prefixToPostfix(prefix, prefix.length());
        System.out.println(postfixExpression);
    }

    private static String prefixToPostfix(String prefix, int n) {
        Stack<String> st = new Stack<>();
        char[] e = prefix.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            if (isOperator(e[i])) {
                String op1 = st.pop();
                String op2 = st.pop();

                String result = op1 + op2 + e[i];

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
            case '/':
            case '+':
            case '-':
            case '*':
                return true;
        }
        return false;
    }
}