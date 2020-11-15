class Node {
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
    static Node head;
    static Node temp;

    public LinkedList() {
        head = null;
        temp = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null)
            temp = head = newNode;
        else {
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
    }

    void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    void reverse() {
        Node currentNode = head;
        Node tempNode = null;

        while (currentNode != null) { // swap next and prev pointers
            tempNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = tempNode;
            currentNode = currentNode.prev; // as prev now contains next 
        }

        if (tempNode != null)
            head = temp.prev;
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
        ll.insert(60);

        ll.print();

        ll.reverse();

        ll.print();
    }
}