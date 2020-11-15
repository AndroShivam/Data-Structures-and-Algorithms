import java.util.LinkedList;
import java.util.Queue;

class LearningDS {
    static Queue<Integer> q = new LinkedList<>();

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

        if (q.isEmpty())
            return;
        else {
            int data = q.peek();
            q.remove();
            reverseQueue();
            q.add(data);
        }
    }
}