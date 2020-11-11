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

    LinkedList() {
        head = null;
        temp = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            temp = head = newNode;
        } else {
            temp.next = newNode;
            temp = temp.next;
        }
    }


    /*
    * We will be using two pointer Algorithm to find middle
    * Where one pointer will take 2 steps at a time while other will take one step at a time
    * when fast becomes/reaches null
    * slow pointer will point to middle element
    *
    * # THIS ALGORITHM IS CALLED FLOYD'S TORTOISE AND HAZE ALGORITHM
    * read more about it here : https://en.wikipedia.org/wiki/Cycle_detection
    */

    void findMiddle() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        Node fastNode = head;
        Node slowNode = head;

        while (fastNode != null && fastNode.next != null) { // fast.next is for odd linkedlist and fast != null is for even
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        System.out.println("Middle element is : " + slowNode.data);
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


        ll.findMiddle();

        // Output
        // Middle element is : 30
    }
}