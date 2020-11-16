class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    static Node head, temp;

    public LinkedList() {
        head = null;
        temp = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null)
            head = temp = newNode;
        else {
            temp.next = newNode;
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

    void getDecimalValue(Node tempHead) {
        int result = 0;

        while (tempHead != null) {
            result = (result << 1) | tempHead.data;
            tempHead = tempHead.next;
        }

        System.out.println(result);
    }
}

class LearningDS {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(0);
        ll.insert(1);

        ll.print();

        ll.getDecimalValue(LinkedList.head);
    }
}

// Output
// 1 0 1
// 5