class Node { // this class represents a Node in a linked list (a Node of two sections one is data part and another is address)
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {

    Node head; // this will point to starting node
    Node temp; // this will point to recently added (last) Node

    LinkedList() {
        head = null;
        temp = null;
    }

    void insert(int data) {
        Node newNode = new Node(data); // create a Node with data
        if (head == null) { // for the first time (object created) head will be null
            temp = head = newNode;
        } else {
            temp.next = newNode; // now we know atleast one Node is present so we make a new link from present node to newNode
            newNode.prev = temp;
            temp = temp.next; // now temp will point to this last Node
        }
    }

    void insertAtBeg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    void insertAtIndex(int data, int position) {
        Node newNode = new Node(data);
        Node currentNode = head;

        //  1  2  3  4  5
        // 10 20 30 40 50

        for (int i = 1; i < position - 1; i++) {
            currentNode = currentNode.next;
        }

        newNode.next = currentNode.next;
        currentNode.next.prev = newNode;
        currentNode.next = newNode;
        newNode.prev = currentNode;
    }

    void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
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

        ll.insertAtBeg(100);
        ll.insertAtEnd(200);

        ll.insertAtIndex(500, 3);

        ll.printLinkedList();

        // Output
        // 100 10 500 20 30 40 50 200 

    }
}