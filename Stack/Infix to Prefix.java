import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {


        String infix = "(A-B/C)*(A/K-L)";
        //  String infix = "A*B+C/D";

        String prefix = infixToPrefix(infix);
        System.out.println(prefix);
    }

    private static String infixToPrefix(String infix) {

        infix = reverse(infix);
        StringBuilder postfixExpression = infixToPostfix(infix, infix.length());

        return reverse(String.valueOf(postfixExpression));
    }


    private static String reverse(String infix) {
        StringBuilder infixReversed = new StringBuilder();
        char[] c = infix.toCharArray();
        for (int i = infix.length() - 1; i >= 0; i--) {
            if (c[i] == ')')
                c[i] = '(';
            else if (c[i] == '(')
                c[i] = ')';
            infixReversed.append(c[i]);
        }
        return infixReversed.toString();
    }

    private static StringBuilder infixToPostfix(String infix, int n) {
        Stack<Character> st = new Stack<>();
        char[] e = infix.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (Character.isLetterOrDigit(e[i]))
                result.append(e[i]);
            else if (e[i] == '(')
                st.push(e[i]);
            else if (e[i] == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && Precedence(e[i]) <= Precedence(st.peek())) {
                    result.append(st.pop());
                }
                st.push(e[i]);
            }
        }
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        return result;
    }

    private static int Precedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else return 0;
    }

}