import java.util.EmptyStackException;

class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T pop() {
        if (top == null)
            throw new EmptyStackException();

        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class LearningDS {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.pop();

        System.out.println(stack.peek());

        // Output
        // 40
    }
}