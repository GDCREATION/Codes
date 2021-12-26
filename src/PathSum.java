public class PathSum {
    /**Given the root of a binary tree and an integer targetSum,
     * return true if the tree has a root-to-leaf path such that
     * adding up all the values along the path equals targetSum.
    A leaf is a node with no children. */
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

    int ts=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ts  = targetSum;
        if(root == null)
            return false;
        boolean d = DFS(root,0);
        return d;
    }
    
    public boolean DFS(TreeNode node, int depth){
        boolean d1 = false;
        boolean d2 = false;
        if(node.left == null && node.right == null){
            if((depth+node.val) == ts)
                return true;
            else
                return false;
        }
            
        if(node.left != null)
         d1 = DFS(node.left,depth+node.val);
        if(node.right != null)
         d2 = DFS(node.right,depth+node.val);
        
        return d1||d2?true:false;
        
    }
}
