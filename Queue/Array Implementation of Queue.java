class LearningDS {
    static int MAX = 10;
    static int[] queue = new int[MAX];
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args) {

        Queue q = new Queue();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);

        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();

    }


    private static class Queue {
        void enQueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
            } else if (isEmpty()) {
                front = rear = 0;
                queue[rear++] = data;
            } else {
                queue[++rear] = data;
            }
        }

        void deQueue() {
            if (isEmpty())
                System.out.println("Queue is Empty");
            else if (front == rear)
                front = rear = -1;
            else {
                System.out.println(queue[front] + " Deleted");
                front++;
            }
        }

        boolean isFull() {
            return rear == MAX - 1;
        }

        boolean isEmpty() {
            return front == -1 && rear == -1;
        }


    }
}