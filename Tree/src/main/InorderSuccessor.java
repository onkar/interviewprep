package main;

/**
 * Set the inorder successor in a binary tree.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class InorderSuccessor {
  public static class BTNode {
    public BTNode next;
    public BTNode left;
    public BTNode right;
    public int data;

    public BTNode() {
      this.next = null;
      this.left = null;
      this.right = null;
      this.data = 0;
    }

    public BTNode(int data) {
      this.next = null;
      this.left = null;
      this.right = null;
      this.data = data;
    }
  }

  private final BTNode root;
  private BTNode next;

  public InorderSuccessor(BTNode root) {
    this.root = root;
    // Initialize the next node to null
    this.next = null;
  }

  public BTNode populateNextInorder() {
    populateNextInorderRecursive(root);
    return root;
  }

  /**
   * Do a reverse inorder traversal and instead of printing the node, set the next pointer
   * 
   * @param root
   */
  private void populateNextInorderRecursive(BTNode root) {
    if (root != null) {
      populateNextInorderRecursive(root.right);
      // Set the rightmost node's next to null and set next to the rightmost node so that when
      // recursion unwinds, the next node will be set properly.
      root.next = next;
      next = root;
      populateNextInorderRecursive(root.left);
    }
  }

}
