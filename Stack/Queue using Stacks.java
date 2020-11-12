import java.util.Stack;

class Queue {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    void enQueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    void deQueue() {
        if (s1.isEmpty())
            System.out.println("Queue is Empty");

        int top = s1.pop();
        System.out.println(top + " Deleted from Queue");
    }
}

class LearningDS {
    public static void main(String[] args) {

        Queue q = new Queue();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);

        q.deQueue();

        // Output
        // 10 Deleted from Queue
    }
}