// Using Extra Stack

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        
        stack.push(x);
        
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            if(x <= minStack.peek()){
                minStack.push(x);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        
        int top = stack.pop();
        
        if(top == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        if(stack.isEmpty())
            return -1;
        
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty())
            return -1;
          
        return minStack.peek();
    }
}

// Without Using Extra Stack

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

// Using LinkedList

class MinStack {

    private class Node{
        int data;
        int min;
        Node next;
        
        private Node(int data, int min){
            this(data, min, null);
        }
        
        private Node(int data, int min, Node next){
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }
    
    private Node head;
    
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */