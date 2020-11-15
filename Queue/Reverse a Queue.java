import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class LearningDS {
    static Queue<Integer> q = new LinkedList<>();
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println(q);
        reverseQueue();
        System.out.println(q);
    }

    private static void reverseQueue() {

        while (!q.isEmpty()) {
            s.push(q.peek());
            q.remove();
        }

        while (!s.isEmpty()) {
            q.add(s.peek());
            s.pop();
        }
    }
}