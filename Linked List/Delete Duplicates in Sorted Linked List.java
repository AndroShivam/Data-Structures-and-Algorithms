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


    void deleteDuplicates() {
        Node currentNode = head;

        while (currentNode.next != null) {
            if (currentNode.data == currentNode.next.data) {
                // change current pointer points to next nodes next
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
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
        ll.insert(10);
        ll.insert(20);
        ll.insert(20);
        ll.insert(20);
        ll.insert(30);
        ll.insert(30);
        ll.insert(30);
        ll.insert(40);
        ll.insert(50);


        System.out.println("Before removing duplicates : ");
        ll.printLinkedList();

        System.out.println("");
        ll.deleteDuplicates();

        System.out.println("After removing duplicates : ");
        ll.printLinkedList();

//        Output : -
//        Before removing duplicates :
//        10 10 20 20 20 30 30 30 40 50
//        After removing duplicates :
//        10 20 30 40 50
    }
}