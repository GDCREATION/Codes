public class InsertBST {
    /**You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them. */
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode res = root;
        while(res != null){
            if(res.val > val){
                if(res.left != null)
                res = res.left;
                else{
                    TreeNode n = new TreeNode(val);
                    res.left = n;
                    break;
                }
            }
            else{
                if(res.right != null)
                res = res.right;
                else{
                    TreeNode n = new TreeNode(val);
                    res.right = n;
                    break;
                }
            }
        }
        return root;
    }
}
