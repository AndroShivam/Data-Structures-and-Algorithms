class Node { // this class represents a Node in a linked list (a Node of two sections one is data part and another is address)
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
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
            temp = temp.next; // now temp will point to this last Node
        }
    }

    void insertAtBeginning(int data) { // create a new node , make it point to head and change head to newnode
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) { // traverse till last node and add link to newnode
        Node newNode = new Node(data);

        Node currentNode = head;
        while (currentNode.next != null) {  // reach last node
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    void insertAtIndex(int data, int position) {
        Node newNode = new Node(data);
        Node currentNode = head;

        //  1  2  3  4  5
        // 10 20 30 40 50

        for (int i = 1; i < position - 1; i++) { // traverse till desired position
            currentNode = currentNode.next;
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;
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

        ll.insertAtBeginning(100);
        ll.insertAtBeginning(200);

        ll.insertAtEnd(300);
        ll.insertAtEnd(400);

        ll.insertAtIndex(500,4);
        ll.printLinkedList();

        // Output
        // 200 100 10 500 20 30 40 50 300 400

    }
}