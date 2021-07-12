class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {

    private BSTNode root;

    public BST() {
        root = null;
    }

    void insert(int data) {
        root = insertUtil(root, data);
    }

    private BSTNode insertUtil(BSTNode root, int data) {
        if (root == null) {
            return new BSTNode(data);
        } else if (data <= root.data) {
            root.left = insertUtil(root.left, data);
        } else {
            root.right = insertUtil(root.right, data);
        }

        return root;
    }

    void inorderTraversal(BSTNode tempRoot) {
        if (tempRoot != null) {
            inorderTraversal(tempRoot.left);
            System.out.print(tempRoot.data + " ");
            inorderTraversal(tempRoot.right);
        }
    }
}

class LearningDS {
    public static void main(String[] args) {

        BST binSearchTree = new BST();

        binSearchTree.insert(10);
        binSearchTree.insert(5);
        binSearchTree.insert(20);
        binSearchTree.insert(1);
        binSearchTree.insert(12);


        binSearchTree.inorderTraversal(BST.root);

    }
}

// Output
// 1 5 10 12 20 (inorder traversal is always sorted)