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


//     we will use Floyd's Tortoise and haze algorithm to find Length of the loop
//     this algo uses two pointers one is faster than other

    int lengthOfLoop() {
        Node fastPtr = head;
        Node slowPtr = head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return countNodes(slowPtr);
            }
        }
        return 0;
    }

    int countNodes(Node slowPtr) {
        int len = 0;
        while (slowPtr.next != null) {
            len++;
            slowPtr = slowPtr.next;
        }
        return len;
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

        int loopLength = ll.lengthOfLoop();
        System.out.println(loopLength);

        // Output -
        // 0

    }
}