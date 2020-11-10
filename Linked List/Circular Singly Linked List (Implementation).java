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
    Node tail; // this will point to the last Node

    LinkedList() {
        head = null;
        tail = null;
    }

    void insert(int data) {
        Node newNode = new Node(data); // create a Node with data
        if (head == null) { // for the first time (object created) head will be null
            tail = head = newNode;
        } else {
            tail.next = newNode; // now we know atleast one Node is present so we make a new link from present node to newNode
            tail = tail.next; // now temp will point to this last Node
        }

        tail.next = head;
    }

    void printLinkedList() {
        Node currentNode = head;

        while(currentNode.next != head){ // in circular Linked List last node doesnt contain null instead it contains address of head
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

        // while loop will terminate without printing the last node as condition becomes false
        // so we have to manually print last node data

        System.out.println(currentNode.data);
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