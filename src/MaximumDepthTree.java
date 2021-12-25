public class MaximumDepthTree {
    /**Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. */
  
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int d = DFS(root,1);
        return d;
    }
    
    public int DFS(TreeNode node, int depth){
        int d1 = 0;
        int d2 = 0;
        if(node.left == null && node.right == null)
            return depth;
        if(node.left != null)
         d1 = DFS(node.left,depth+1);
        if(node.right != null)
         d2 = DFS(node.right,depth+1);
        
        return d1>d2?d1:d2;
        
    }
    
}
