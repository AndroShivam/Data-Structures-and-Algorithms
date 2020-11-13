import java.util.Stack;

class LearningDS {
    public static void main(String[] args) {


        /*
        scan from left to right
        if operand push onto the stack
        if operator pop two elements from the stack and arrange in the format <operator> <operand 2> <operand 1>
        */

        String postfix = "ABC/-AK/L-*";
        String prefixExpression = postfixToPrefix(postfix, postfix.length());
        System.out.println(prefixExpression);
    }

    private static String postfixToPrefix(String postfix,int n){
        Stack<String> st = new Stack<>();
        char[] e = postfix.toCharArray();

        for(int i=0; i<n; i++){
            if(isOperator(e[i])){

                String op1 = st.pop();
                String op2 = st.pop();

                String result = e[i] + op2 + op1;
                st.push(result);

            }else{
                st.push(String.valueOf(e[i]));
            }
        }
        return st.peek();
    }

    private static boolean isOperator(char c){
        switch (c){
            case '^':
            case '/':
            case '*':
            case '-':
            case '+':
                return true;
        }
        return false;
    }
}