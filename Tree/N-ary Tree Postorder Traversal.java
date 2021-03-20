// Recursive

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) return list;
        
        for(Node child : root.children)
            postorder(child);
        
        list.add(root.val);
        
        return list;
    }
}