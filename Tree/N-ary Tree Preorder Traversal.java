// Iterative

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node current = stack.pop();
            list.add(current.val);
            
            for(int i=current.children.size() - 1; i>=0; i--)
                stack.push(current.children.get(i));
        }
        
        return list;
    }
}

// Recursive

class Solution {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return list;
        
        list.add(root.val);
        for(Node child : root.children)
            preorder(child);
        
        return list;
    }
}