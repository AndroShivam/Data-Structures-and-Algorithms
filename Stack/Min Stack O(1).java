import java.util.Stack;

class MyStack {

    Stack<Integer> stack;
    int minElement;

    MyStack() {
        stack = new Stack<>();
    }

    void push(int data) {
        if (stack.isEmpty()) {
            minElement = data;
            stack.push(data);
            System.out.println("Inserted : " + data);
            return;
        }
        if (data < minElement) {
            stack.push(2 * data - minElement);
            minElement = data;
        } else
            stack.push(data);

        System.out.println("Inserted : " + data);
    }

    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Top most element removed : ");
        int top = stack.pop();

        if (top < minElement) { // minElement stores the actual value of top
            System.out.println(minElement);
            minElement = 2 * minElement - top;
        } else {
            System.out.println(top);
        }
    }

    void peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        int top = stack.peek();

        System.out.println("Top most element is : ");

        if (top < minElement) // means minElement stores the actual value of it
            System.out.println(minElement);
        else
            System.out.println(top);
    }

    void getMin() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Min Element : " + minElement);
        }
    }


}

class LearningDS {
    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(40);
        myStack.push(1);
        myStack.push(11);
        myStack.push(98);

        myStack.getMin();
    }
}