class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    static Node head;
    static Node temp;

    public LinkedList() {
        head = null;
        temp = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null)
            temp = head = newNode;
        else {
            temp.next = newNode;
            temp = newNode;
        }
    }

    void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    void reverse(Node tempHead) {

        if (tempHead.next == null) {
            head = tempHead;
            return;
        }

        reverse(tempHead.next);

        Node q = tempHead.next;
        q.next = tempHead;
        tempHead.next = null;
    }
}

class LearningDS {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insert(10);
        ll.insert(20);
        ll.insert(30);
        ll.insert(40);
        ll.insert(50);
        ll.insert(60);

        ll.print();

        ll.reverse(LinkedList.head);

        ll.print();
    }
}