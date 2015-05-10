package main;


/**
 * Connect nodes on same level in a complete binary tree
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class ConnectNodes {
  public static void connect(SpecialNode root) {
    root.next = null;
    connectRecurse(root);
  }

  // Use modified preorder traversal
  private static void connectRecurse(SpecialNode root) {
    if (root == null)
      return;

    if (root.left != null) {
      root.left.next = root.right;
    }
    if (root.right != null) {
      root.right.next = (root.next == null) ? null : root.next.left;
    }

    connectRecurse(root.left);
    connectRecurse(root.right);
  }
}
