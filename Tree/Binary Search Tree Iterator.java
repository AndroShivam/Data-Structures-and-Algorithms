// Store inorder traversal in array 

// Time Complexity - O(N)
// Space Complexity - O(N)

class BSTIterator {

    ArrayList<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.index = -1;
        this.inorder(root);
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        if(root.left != null) 
            inorder(root.left);
        this.list.add(root.val);
        if(root.right != null) 
            inorder(root.right);
    }
    
    public int next() {
        return this.list.get(++this.index);
    }
    
    public boolean hasNext() {
        return this.index + 1 < this.list.size();
    }
}

// Time Complexity -
// hasNext() - O(1)
// next() - O(N) in the worst case
// However, the important thing to note here is that we only make such a call for nodes which have a right child. 
// Otherwise, we simply return. Also, even if we end up calling the helper function, it won't always process N nodes. They will be much lesser. 
// Only if we have a skewed tree would there be N nodes for the root. But that is the only node for which we would call the helper function.

// Space Complexity - O(N)

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode current = stack.pop();
        pushAll(current.right);
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAll(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}