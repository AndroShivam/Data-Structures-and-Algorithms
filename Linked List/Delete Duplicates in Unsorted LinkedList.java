class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head, temp;

    public LinkedList() {
        head = null;
        temp = null;
    }

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null)
            head = temp = newNode;
        else {
            temp.next = newNode;
            temp = newNode;
        }
    }

    void removeDuplicates() {
        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class LearningDS {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(20);

        System.out.println("Before Removing Duplicates");
        list.print();
        System.out.println("After Removing Duplicates");
        list.removeDuplicates();
        list.print();
    }
}