/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        
        if(root == null)
            return resultList;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int level = queue.size();
            
            for(int i=0; i<level; i++){
                TreeNode current = queue.poll();
                
                if(current.left != null) 
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
                
                levelList.add(current.val);
            }
            
            resultList.add(levelList);
        }
        
        return resultList;
        
    }
}


/*
   3
   / \
  9  20
    /  \
   15   7

Output : 
[
  [3],
  [9,20],
  [15,7]
]

*/