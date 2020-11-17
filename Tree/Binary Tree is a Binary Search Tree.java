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


    boolean isBSTUtil(BSTNode root, int minValue, int maxValue) {

        if (root == null)
            return true;

        return root.data > minValue && root.data < maxValue
                && isBSTUtil(root.left, minValue, root.data)
                && isBSTUtil(root.right, root.data, maxValue);
    }

    boolean isBST(BSTNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

        boolean isBST = binSearchTree.isBST(BST.root);
        System.out.println(isBST);

    }
}

// Output
// true