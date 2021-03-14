class Tree
{
	public Node inorderSuccessor(Node root,Node x)
     {
      Node current = findNode(root, x.data);
      if(current == null) return null;
      
      // Case 1 : Node has a right subtree
      if(current.right != null){
          return findMin(current.right);
      }else{   // Case 2 : Node doesn't have a right subtree 
          Node successor = null;
          Node ancestor = root;
          
          while(ancestor != current){
              if(current.data < ancestor.data){ // node is on the left side 
                  successor = ancestor;
                  ancestor = ancestor.left;
              }else{
                  ancestor = ancestor.right; // node is on right side (i.e its parent is already visited)
              }
          }
          return successor;
      }
     }
    
     private Node findMin(Node node){
         if(node == null) return null;
         while(node.left != null){
             node = node.left;
         }
         return node;
     }
     
     private Node findNode(Node node, int data){
         if(node == null){
             return null;
         }else if(node.data == data){
             return node;
         }else if(node.data > data){
             return findNode(node.left, data);
         }else{
             return findNode(node.right, data);
         }
     }
}