import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTree {

    /**Given the root of a binary tree, return the level order traversal of its nodes' values.
     * (i.e., from left to right, level by level). */
    
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
 
    public List<List<Integer>> levelOrder(TreeNode root) {
        int n=0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        queue.add(root);
        n=1;
        while(!queue.isEmpty()){
            List<Integer> in =new ArrayList<>();
            int m = 0;
            for(int i=0;i<n;i++){
                TreeNode ne = queue.poll();
                in.add(ne.val);
                if(ne.left != null){
                    queue.add(ne.left);
                    m++;
                }
                if(ne.right != null){
                    queue.add(ne.right);
                    m++;
                }
                
            }
            n=m;
            res.add(in);
        }
        return res;
    }
}