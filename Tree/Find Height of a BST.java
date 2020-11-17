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

    static BSTNode root;

    public BST() {
        root = null;
    }

    void insert(int data) {
        root = insertUtil(root, data);
    }

    BSTNode insertUtil(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
        } else if (data <= root.data) {
            root.left = insertUtil(root.left, data);
        } else {
            root.right = insertUtil(root.right, data);
        }

        return root;
    }

    int findHeight(BSTNode root) {
        if (root == null)
            return -1;

        int leftSubtreeHeight = findHeight(root.left);
        int rightSubtreeHeight = findHeight(root.right);

        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
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

        int height = binSearchTree.findHeight(BST.root);
        System.out.println(height);

    }
}

// Output
// 2