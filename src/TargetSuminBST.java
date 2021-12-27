import java.util.*;

/**Given the root of a Binary Search Tree and a target number k, return true if 
 * there exist two elements in the BST such that their sum is equal to the given target. */

public class TargetSuminBST {
    
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
  
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> map = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode r = q.poll();
            int e = r.val;
            if(map.contains(k-e)){
                return true;
            }
            else
                map.add(e);
            if(r.left != null)
                q.add(r.left);
            if(r.right != null)
                q.add(r.right);
        }
        
        return false;
    }
}
