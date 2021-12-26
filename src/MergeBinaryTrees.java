import java.util.Stack;

public class MergeBinaryTrees {
    

    /**You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees. */

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
 
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1 == null)
           return root2;
        if(root2 == null)
            return root1;
        
        traverseTree(root1,root2);
        return root1;
    }
    
    public void traverseTree(TreeNode root1, TreeNode root2){
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);
        while(!stack.isEmpty()){
            TreeNode s1 =stack.pop();
            TreeNode s2 = stack.pop();
            s1.val+=s2.val;
            if(s1.left !=null&& s2.left !=null)
            {
                stack.push(s2.left);
                stack.push(s1.left);
            }
            if(s1.right !=null&& s2.right !=null)
            {
                stack.push(s2.right);
                stack.push(s1.right);
            }
            
            if(s1.left == null){
                s1.left = s2.left;
            }
            if(s1.right == null){
                s1.right = s2.right;
            }
        }
    }
}
