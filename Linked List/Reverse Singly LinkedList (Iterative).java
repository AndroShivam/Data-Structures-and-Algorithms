class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node temp;

    public LinkedList() {
        this.head = null;
        this.temp = null;
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

    void reverse() {
        Node currentNode = head;
        Node prevNode = null;
        Node nextNode = null;


        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        if(prevNode != null)
            this.head = prevNode;
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

        ll.print();

        ll.reverse();

        ll.print();
    }
}