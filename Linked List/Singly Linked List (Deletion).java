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

    void deleteAtBeg() { // Java Garbage collector will automatically delete unreferenced objects (in C,C++ we have to manually perform deletion)
        head = head.next;
    }

    void deleteAtEnd() {
        Node currentNode = head;
        while (currentNode.next.next != null) { // reach second last node
            currentNode = currentNode.next;
        }
        currentNode.next = null;
    }

    void deleteAtIndex(int data, int position) {

        Node currentNode = head;
        for (int i = 1; i < position - 1; i++) {
            currentNode = currentNode.next;
        }

        //  1  2  3  4  5
        // 10 20 30 40 50

        currentNode.next = currentNode.next.next;
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


        ll.deleteAtBeg();
        ll.deleteAtEnd();

        ll.deleteAtIndex(100,3);
        ll.printLinkedList();

        // Output
        // 20 30

    }
}