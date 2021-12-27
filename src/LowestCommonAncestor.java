public class LowestCommonAncestor {
    /**Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
that has both p and q as descendants (where we allow a node to be a descendant of itself).” */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root,p,q);
    }
    
    TreeNode findLCA(TreeNode node, TreeNode n1, TreeNode n2)
    {
        if (node == null)
            return null;
 
        if (node.val == n1.val || node.val == n2.val)
            return node;
        
        TreeNode left_lca = findLCA(node.left, n1, n2);
        TreeNode right_lca = findLCA(node.right, n1, n2);
 
        if (left_lca!=null && right_lca!=null)
            return node;
        
        return (left_lca != null) ? left_lca : right_lca;
    }
 
}
