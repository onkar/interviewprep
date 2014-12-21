package main;

import main.BinarySearchTree.BSTNode;

public class BinaryUnivalTree {
  public boolean isUnival(BSTNode root) {
    if (root == null || root.left == null && root.right == null)
      return true;

    if (root.left != null && root.right == null && root.data == root.left.data)
      return isUnival(root.left);

    if (root.right != null && root.left == null && root.data == root.right.data)
      return isUnival(root.right);

    return root.data == root.left.data && root.data == root.right.data && isUnival(root.left)
        && isUnival(root.right);
  }

  public static int count;

  public boolean getUnivalSubtrees(BSTNode root) {
    if (root == null)
      return true;
    boolean left = getUnivalSubtrees(root.left);
    boolean right = getUnivalSubtrees(root.right);
    if (left && right && (root.left == null || root.left.data == root.data)
        && (root.right == null || root.right.data == root.data)) {
      count++;
      return true;
    } else {
      return false;
    }

  }
}
