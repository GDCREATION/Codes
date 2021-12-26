/**You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL. */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class NextPointerTree {
        public Node connect(Node root) {
            
            if (root == null) {
                return root;
            }
            
            // Start with the root node. There are no next pointers
            // that need to be set up on the first level
            Node leftmost = root;
            
            // Once we reach the final level, we are done
            while (leftmost.left != null) {
                
                // Iterate the "linked list" starting from the head
                // node and using the next pointers, establish the 
                // corresponding links for the next level
                Node head = leftmost;
                
                while (head != null) {
                    
                    // CONNECTION 1
                    head.left.next = head.right;
                    
                    // CONNECTION 2
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }
                    
                    // Progress along the list (nodes on the current level)
                    head = head.next;
                }
                
                // Move onto the next level
                leftmost = leftmost.left;
            }
            
            return root;
        }
    }
