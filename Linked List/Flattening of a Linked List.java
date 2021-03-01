class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}


class GfG {
    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);

        root = mergeLists(root, root.next);

        return root;
    }

    Node mergeLists(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node dummy = new Node(-1);
        Node current = dummy;

        while (a != null && b != null) {
            if (a.data > b.data) {
                current.bottom = b;
                b = b.bottom;
            } else {
                current.bottom = a;
                a = a.bottom;
            }

            current = current.bottom;
        }

        if (a != null) {
            current.bottom = a;
        } else {
            current.bottom = b;
        }

        return dummy.bottom;
    }
}