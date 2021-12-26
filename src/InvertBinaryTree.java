import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    /**Given the root of a binary tree, invert the tree, and return its root. */
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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return null;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode rt = queue.poll();
            TreeNode q = rt.left;
            rt.left = rt.right;
            rt.right = q;
            if(rt.left != null)
                queue.add(rt.left);
            if(rt.right != null)
                queue.add(rt.right);
        }
        
        return root;
        
    }
}
