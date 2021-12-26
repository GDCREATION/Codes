public class SearchBinarySearchTree {

    /**You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null. */

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
  
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode res = root;
        while(res !=null){
            if(res.val == val){
                return res;
            }else if(res.val > val)
                res = res.left;
            else 
                res = res.right;
        }
        return null;
    }
}
