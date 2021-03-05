class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> result = new ArrayList<>();
      if(root == null) return result;
            
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      
      while(!queue.isEmpty()){
          int n = queue.size();
          
          for(int i=1; i<=n; i++){
              Node current = queue.poll();
              
              if(i == 1) // first element of a level
                  result.add(current.data);
              
              if(current.left != null) queue.offer(current.left);
              if(current.right != null) queue.offer(current.right);
          }
      }
      
      return result;
    }
}