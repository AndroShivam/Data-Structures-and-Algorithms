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
    Node temp = null; // this will point to the last added Node

    LinkedList() {
        head = null;
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

    void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) { // linkedlist is empty when currentNode == null
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

    }
}

class LearningDS{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insert(10);
        ll.insert(20);
        ll.insert(30);
        ll.insert(40);
        ll.insert(50);

        ll.printLinkedList();

    }
}