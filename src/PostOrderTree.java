import java.util.ArrayList;
import java.util.List;

public class PostOrderTree {
    
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
 
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }
    
    public void traverse(TreeNode root){
        if(root == null)
            return;
        if(root.left != null)
            traverse(root.left);
        if(root.right != null)
            traverse(root.right);
        res.add(root.val);
    }
}