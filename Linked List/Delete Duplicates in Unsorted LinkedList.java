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

        // we will use two pointers
        // ptr1 will point to one node at a time and ptr2 will traverse whole list and checks if any duplicate exists
        // if found we change links

        Node ptr1 = head;
        Node ptr2;

        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) { // we didn't use ptr2.data because ptr1.data points to the same Node and we want any duplicate
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
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

        ll.insert(39);
        ll.insert(12);
        ll.insert(45);
        ll.insert(2);
        ll.insert(2);
        ll.insert(12);
        ll.insert(39);
        ll.insert(5);
        ll.insert(14);
        ll.insert(5);


        System.out.println("Before removing duplicates : ");
        ll.printLinkedList();

        System.out.println("");
        ll.deleteDuplicates();

        System.out.println("After removing duplicates : ");
        ll.printLinkedList();

//        Output : -
//        Before removing duplicates :
//        39 12 45 2 2 12 39 5 14 5
//        After removing duplicates :
//        39 12 45 2 5 14
    }
}