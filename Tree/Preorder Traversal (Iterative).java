import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    static Node root;

    public BST() {
        root = null;
    }

    void insert(int data) {
        root = insertUtil(root, data);
    }

    Node insertUtil(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (data <= root.data) {
            root.left = insertUtil(root.left, data);
        } else {
            root.right = insertUtil(root.right, data);
        }

        return root;
    }

    void preorderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            System.out.print(current.data + " ");

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
}

class LearningDS {
    public static void main(String[] args) {
        BST binSearchTree = new BST();

        binSearchTree.insert(10);
        binSearchTree.insert(5);
        binSearchTree.insert(12);
        binSearchTree.insert(1);
        binSearchTree.insert(8);

        binSearchTree.preorderTraversal(BST.root);

        // Output - 10 5 1 8 12
    }
}