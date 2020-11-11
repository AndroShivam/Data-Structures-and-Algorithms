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


//     we will use Floyd's Tortoise and haze algorithm to find loop , this algo uses two pointers one is faster than other

    void findLoop(){
        Node fastPtr = head;
        Node slowPtr = head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr){
                System.out.println("Loop Found!");
                return;
            }
        }
        System.out.println("No Loop Found!");
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

        ll.insert(12);
        ll.insert(45);
        ll.insert(2);
        ll.insert(12);
        ll.insert(39);
        ll.insert(14);
        ll.insert(5);

        ll.findLoop();

        // Output -
        // No Loop Found!

    }
}